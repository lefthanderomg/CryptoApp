package andrey.murzin.screen_currency.screen.list

import andrey.murzin.core.routing.FlowRouter
import andrey.murzin.core.utils.Logger
import andrey.murzin.core_ui.ViewModelOwnerFactory
import andrey.murzin.core_ui.base.BaseFragment
import andrey.murzin.core_ui.ext.getViewModel
import andrey.murzin.screen_currency.R
import andrey.murzin.screen_currency.screen.flow.di.provider.CurrencyFlowHolder
import andrey.murzin.screen_currency.screen.list.adapter.CurrencyListAdapter
import andrey.murzin.screen_currency.screen.list.di.component.CurrencyListComponent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
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
        val currencyListAdapter = CurrencyListAdapter(context!!) {
            viewModel.goCoinDetail(it)
        }

        with(rvCurrencyList) {
            adapter = currencyListAdapter
            layoutManager = LinearLayoutManager(context)
        }

        viewModel.getCurrency().observe(
            viewLifecycleOwner,
            Observer {
                swipeRefreshLayout.isRefreshing = it.loading
                currencyListAdapter.submitList(it.data)
            }
        )
    }
}