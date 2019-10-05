package andrey.murzin.screen_currency.screen.flow.di.provider

import andrey.murzin.core.di.provider.AppProvider
import andrey.murzin.core.routing.StartPurchaseFlow
import andrey.murzin.core.routing.FlowRouter

interface CurrencyFlowProvider : AppProvider {
    fun getFlowRouter(): FlowRouter
    fun provideStartPurcheseFlow(): StartPurchaseFlow
}