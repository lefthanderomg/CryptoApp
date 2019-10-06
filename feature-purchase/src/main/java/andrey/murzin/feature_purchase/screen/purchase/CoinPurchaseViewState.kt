package andrey.murzin.feature_purchase.screen.purchase

import andrey.murzin.core.model.CoinDetail
import andrey.murzin.core_ui.model.ViewState

data class CoinPurchaseViewState(
    val data: CoinDetail?,
    val loading: Boolean,
    val error: String
) : ViewState {
    companion object {
        fun createLoadingState() =
            CoinPurchaseViewState(
                data = null,
                loading = true,
                error = ""
            )

        fun createErrorState(error: String) =
            CoinPurchaseViewState(
                data = null,
                loading = false,
                error = error
            )
    }
}