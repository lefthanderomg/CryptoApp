package andrey.murzin.screen_currency.screen.flow.di.provider

import andrey.murzin.core.di.provider.AppProvider
import andrey.murzin.core.routing.FlowRouter
import andrey.murzin.core.routing.StartPurchaseFlow
import andrey.murzin.feature_coin_detail.di.provider.CoinInfoProvider

interface CurrencyFlowProvider : AppProvider, CoinInfoProvider {
    fun getFlowRouter(): FlowRouter
    fun provideStartPurchaseFlow(): StartPurchaseFlow
}