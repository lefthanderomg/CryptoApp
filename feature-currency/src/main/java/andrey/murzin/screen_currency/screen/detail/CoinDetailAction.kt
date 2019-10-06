package andrey.murzin.screen_currency.screen.detail

import andrey.murzin.core_ui.model.Action

sealed class CoinDetailAction : Action {
    object BuyCoin : CoinDetailAction()
    object Retry : CoinDetailAction()
}