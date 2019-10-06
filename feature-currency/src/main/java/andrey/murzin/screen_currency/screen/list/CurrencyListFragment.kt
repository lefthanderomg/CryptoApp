package andrey.murzin.screen_currency.screen.list

import andrey.murzin.core.model.Coin
import andrey.murzin.core.routing.FlowRouter
import andrey.murzin.core.utils.Logger
import andrey.murzin.core_ui.ViewModelOwnerFactory
import andrey.murzin.core_ui.base.BaseFragment
import andrey.murzin.core_ui.ext.getViewModel
import andrey.murzin.core_ui.ext.showMessage
import andrey.murzin.core_ui.model.ViewState
import andrey.murzin.screen_currency.R
import andrey.murzin.screen_currency.screen.flow.di.provider.CurrencyFlowHolder
import andrey.murzin.screen_currency.screen.list.adapter.CurrencyListAdapterDelegate
import andrey.murzin.screen_currency.screen.list.di.component.CurrencyListComponent
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

    @Inject
    lateinit var flowRouter: FlowRouter

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

    override fun onBackPressed() {
        flowRouter.exit()
    }

    override fun clearScope() {
        CurrencyListComponent.Initializer.componentInstance.clearInstance()
    }

    private fun initCurrencyList() {
        val currencyListAdapterDelegate = CurrencyListAdapterDelegate(
            context!!
        ) { coin ->
            viewModel.goCoinDetail(coin)
        }
        val delegatesManager =
            AdapterDelegatesManager<List<Coin>>().apply {
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
            viewLifecycleOwner,
            Observer {
                when (it) {
                    is ViewState.Loading -> {
                        logger.d(TAG + "state loading")
                        swipeRefreshLayout.isRefreshing = true
                    }
                    is ViewState.Data<List<Coin>> -> {
                        logger.d(TAG + "state data")
                        swipeRefreshLayout.isRefreshing = false
                        currencyListAdapter.items = it.data
                        currencyListAdapter.notifyDataSetChanged()
                    }
                    is ViewState.Error -> {
                        logger.d(TAG + "state error")
                        swipeRefreshLayout.isRefreshing = false
                        showMessage(it.message)
                    }
                }
            }
        )
    }
}