package andrey.murzin.screen_currency.screen.list

import andrey.murzin.core.model.Coin
import andrey.murzin.core_ui.model.Action

sealed class CurrencyListAction : Action {
    object Retry : CurrencyListAction()
    data class NavigateDetail(val coin: Coin) : CurrencyListAction()
}