package andrey.murzin.feature_purchase.screen.purchase

import andrey.murzin.core_ui.model.Action

sealed class CoinPurchaseAction : Action {
    object Retry : CoinPurchaseAction()
    object BuyCoin : CoinPurchaseAction()
}