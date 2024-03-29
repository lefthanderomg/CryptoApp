package andrey.murzin.feature_purchase.screen.flow.provider

import andrey.murzin.core.di.provider.MainToolsProvider
import andrey.murzin.core.routing.FlowRouter
import andrey.murzin.feature_coin_detail.di.provider.CoinInfoProvider

interface PurchaseFlowProvider : CoinInfoProvider, MainToolsProvider {
    fun getFlowRouter(): FlowRouter
}