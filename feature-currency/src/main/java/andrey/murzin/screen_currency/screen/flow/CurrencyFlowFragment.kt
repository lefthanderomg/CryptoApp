package andrey.murzin.screen_currency.screen.flow

import andrey.murzin.core.di.holder.ActivityToolsHolder
import andrey.murzin.core_ui.base.BaseFlowFragment
import andrey.murzin.feature_coin_detail.di.component.CoinInfoComponent
import andrey.murzin.screen_currency.R
import andrey.murzin.screen_currency.Screens
import andrey.murzin.screen_currency.screen.flow.di.component.CurrencyFlowComponent
import andrey.murzin.screen_currency.screen.flow.di.provider.CurrencyFlowHolder
import andrey.murzin.screen_currency.screen.flow.di.provider.CurrencyFlowInjector
import andrey.murzin.screen_currency.screen.flow.di.provider.CurrencyFlowProvider
import android.os.Bundle
import android.view.View

class CurrencyFlowFragment : BaseFlowFragment(), CurrencyFlowHolder {

    override fun getContainer(): Int = R.id.containerFlow

    override fun getLayoutResId(): Int = R.layout.fragment_cryptocurrency_flow

    override fun clearScope() {
        CurrencyFlowComponent.Initializer.componentInstance.clearInstance()
    }

    override fun inject() {
        getOrCreateComponent().inject(this)
    }

    override fun getCurrentFlowProvider(): CurrencyFlowProvider = getOrCreateComponent()

    override fun initialScreen() {
        flowRouter.newRootScreen(Screens.CurrencyListScreen)
    }

    private fun getOrCreateComponent(): CurrencyFlowComponent {
        val parentComponentHolder = activity as ActivityToolsHolder
        return CurrencyFlowComponent.Initializer.componentInstance.init(
            CurrencyFlowInjector(
                parentComponentHolder.getActivityToolsProvider(),
                CoinInfoComponent.Initializer.componentInstance.init(
                    parentComponentHolder.getActivityToolsProvider()
                )
            )
        )
    }
}