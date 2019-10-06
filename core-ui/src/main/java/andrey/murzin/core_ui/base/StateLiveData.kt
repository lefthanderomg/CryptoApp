package andrey.murzin.core_ui.base
//
//import andrey.murzin.core_ui.model.ViewState
//import androidx.lifecycle.MutableLiveData
//
//class SingleLiveData<T> : MutableLiveData<Any>() {
//
//    override fun setValue(value: ViewState<T>?) {
//        super.setValue(value)
//        if (value is ViewState.Error) {
//            super.setValue(ViewState.Idle())
//        }
//    }
//}