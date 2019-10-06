package andrey.murzin.screen_currency.screen.list

import andrey.murzin.core.model.Coin
import andrey.murzin.core_ui.model.ViewState

data class CurrencyListViewState(
    val data: List<Coin>,
    val loading: Boolean,
    val error: String
) : ViewState {

    companion object {
        fun createLoadingState() =
            CurrencyListViewState(
                data = emptyList(),
                loading = true,
                error = ""
            )

        fun createErrorState(error: String) =
            CurrencyListViewState(
                data = emptyList(),
                loading = false,
                error = error
            )
    }
}