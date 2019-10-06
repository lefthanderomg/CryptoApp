package andrey.murzin.feature_purchase.screen.purchase

import andrey.murzin.core.model.CoinDetail
import andrey.murzin.core_ui.model.ViewState

data class CoinPurchaseViewState(
    val data: CoinDetail?,
    val loading: Boolean,
    val buyCoin: Int,
    val retry: Retry,
    val error: String
) : ViewState {
    companion object {
        fun createDataState(data: CoinDetail) =
            CoinPurchaseViewState(
                data = data,
                loading = false,
                retry = Retry(false, RetryType.NONE),
                error = "",
                buyCoin = 0
            )

        fun createDataState(data: CoinDetail?, buyCoin: Int) =
            CoinPurchaseViewState(
                data = data,
                loading = false,
                retry = Retry(false, RetryType.NONE),
                error = "",
                buyCoin = buyCoin
            )

        fun createLoadingState(oldState: CoinPurchaseViewState? = null) =
            CoinPurchaseViewState(
                data = oldState?.data,
                loading = true,
                retry = Retry(false, RetryType.NONE),
                error = "",
                buyCoin = oldState?.buyCoin ?: 0
            )

        fun createErrorState(
            error: String,
            retryType: RetryType,
            oldState: CoinPurchaseViewState? = null
        ) =
            CoinPurchaseViewState(
                data = oldState?.data,
                loading = false,
                retry = Retry(
                    true,
                    retryType
                ),
                error = error,
                buyCoin = oldState?.buyCoin ?: 0
            )
    }

    data class Retry(
        val retry: Boolean,
        val type: RetryType
    )

    enum class RetryType {
        BUY,
        COIN_INFO,
        NONE
    }
}