package andrey.murzin.core_ui.model

sealed class ViewState<out T> {
    class Loading<T> : ViewState<T>()
    data class Error<T>(
        val message: String
    ) : ViewState<T>()

    data class Data<T>(
        val data: T
    ) : ViewState<T>()
    class Idle<T> : ViewState<T>()
}
