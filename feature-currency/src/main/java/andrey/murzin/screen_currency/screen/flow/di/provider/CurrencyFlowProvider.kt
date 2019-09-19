package andrey.murzin.screen_currency.screen.flow.di.provider

import andrey.murzin.core.di.provider.AppProvider
import andrey.murzin.screen_currency.FlowRouter

interface CurrencyFlowProvider : AppProvider {
    fun getFlowRouter(): FlowRouter
}