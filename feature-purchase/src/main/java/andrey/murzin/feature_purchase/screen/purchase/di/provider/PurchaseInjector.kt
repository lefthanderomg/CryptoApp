package andrey.murzin.feature_purchase.screen.purchase.di.provider

import andrey.murzin.feature_purchase.screen.flow.provider.PurchaseFlowProvider

data class PurchaseInjector(
    val purchaseFlowProvider: PurchaseFlowProvider,
    val id: Int
)