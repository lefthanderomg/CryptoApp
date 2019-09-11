package andrey.murzin.cryptoapp.presetation.feature.currency.list

import andrey.murzin.cryptoapp.R
import andrey.murzin.cryptoapp.di.feature.factory.ViewModelOwnerFactory
import andrey.murzin.cryptoapp.domain.entity.CoinEntity
import andrey.murzin.cryptoapp.presetation.base.BaseFragment
import andrey.murzin.cryptoapp.presetation.feature.currency.flow.di.provider.CurrencyFlowHolder
import andrey.murzin.cryptoapp.presetation.feature.currency.list.adapter.CurrencyListAdapterDelegate
import andrey.murzin.cryptoapp.presetation.feature.currency.list.di.component.CurrencyListComponent
import andrey.murzin.cryptoapp.presetation.feature.tool.ext.getViewModel
import andrey.murzin.cryptoapp.presetation.model.ViewState
import andrey.murzin.cryptoapp.tools.logger.Logger
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import kotlinx.android.synthetic.main.fragment_currency_list.*
import javax.inject.Inject

class CurrencyListFragment : BaseFragment() {

    companion object {
        private const val TAG = "CurrencyListFragment"
    }

    @Inject
    lateinit var viewModelOwnerFactory: ViewModelOwnerFactory
    @Inject
    lateinit var logger: Logger

    private lateinit var viewModel: CurrencyListViewModel

    override fun getLayoutResId(): Int = R.layout.fragment_currency_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = getViewModel(viewModelOwnerFactory)
        swipeRefreshLayout.setOnRefreshListener {
            viewModel.refreshData()
        }
        initCurrencyList()
    }

    override fun inject() {
        val parentComponent = parentFragment as CurrencyFlowHolder
        CurrencyListComponent.Initializer.componentInstance.init(
            parentComponent.getCurrentFlowProvider()
        ).inject(this)
    }

    override fun clearScope() {
        CurrencyListComponent.Initializer.componentInstance.clearInstance()
    }

    private fun initCurrencyList() {
        val currencyListAdapterDelegate = CurrencyListAdapterDelegate(context!!)
        val delegatesManager =
            AdapterDelegatesManager<List<CoinEntity>>().apply {
                addDelegate(currencyListAdapterDelegate)
            }
        val currencyListAdapter = ListDelegationAdapter(delegatesManager)
        with(rvCurrencyList) {
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                ).apply {
                    setDrawable(ContextCompat.getDrawable(context, R.drawable.diveder_gone_power)!!)
                })
            layoutManager = LinearLayoutManager(context)
            adapter = currencyListAdapter
        }

        viewModel.getCurrency().observe(
            this,
            Observer {
                when (it) {
                    is ViewState.Loading -> {
                        swipeRefreshLayout.isRefreshing = true
                    }
                    is ViewState.Data<List<CoinEntity>> -> {
                        swipeRefreshLayout.isRefreshing = false
                        currencyListAdapter.items = it.data
                        currencyListAdapter.notifyDataSetChanged()
                    }
                }
            }
        )
    }
}