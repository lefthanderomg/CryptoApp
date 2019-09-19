package andrey.murzin.screen_currency.screen.detail

import andrey.murzin.core_ui.base.BaseFragment
import andrey.murzin.screen_currency.FlowRouter
import andrey.murzin.screen_currency.R
import andrey.murzin.screen_currency.screen.detail.di.CoinDetailComponent
import andrey.murzin.screen_currency.screen.flow.di.provider.CurrencyFlowHolder
import andrey.murzin.screen_currency.screen.list.di.component.CurrencyListComponent
import javax.inject.Inject

class CoinDetailFragment : BaseFragment() {

    @Inject
    lateinit var flowRouter: FlowRouter

    override fun getLayoutResId(): Int = R.layout.fragment_coin_detail

    override fun inject() {
        val parentComponent = parentFragment as CurrencyFlowHolder
        CoinDetailComponent.Initializer.componentInstance.init(
            parentComponent.getCurrentFlowProvider()
        ).inject(this)
    }

    override fun clearScope() {
        CoinDetailComponent.Initializer.componentInstance.clearInstance()
    }

    override fun onBackPressed() {
        flowRouter.exit()
    }
}