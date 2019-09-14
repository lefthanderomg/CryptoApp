package andrey.murzin.cryptoapp.presetation.model

sealed class ViewState<out T> {
    class Loading<T> : ViewState<T>()
    class Error<T>: ViewState<T>()
    data class Data<T>(
        val data: T
    ) : ViewState<T>()
}
