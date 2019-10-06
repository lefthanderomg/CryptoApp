package andrey.murzin.screen_currency.screen.detail

import andrey.murzin.core.model.CoinDetail
import andrey.murzin.core_ui.model.ViewState

data class CoinDetailViewState(
    val data: CoinDetail?,
    val loading: Boolean,
    val error: String
) : ViewState {
    companion object {
        fun createLoadingState() =
            CoinDetailViewState(
                data = null,
                loading = true,
                error = ""
            )

        fun createErrorState(error: String) =
            CoinDetailViewState(
                data = null,
                loading = false,
                error = error
            )
    }
}