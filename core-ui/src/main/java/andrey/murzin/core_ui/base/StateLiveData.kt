//package andrey.murzin.core_ui.base
//
//import andrey.murzin.core_ui.model.ViewState
//import androidx.lifecycle.MutableLiveData
//
//class StateLiveData<T> : MutableLiveData<ViewState<T>>() {
//
//    override fun setValue(value: ViewState<T>?) {
//        super.setValue(value)
//        if (value is ViewState.Error) {
//            super.setValue(ViewState.Idle())
//        }
//    }
//}