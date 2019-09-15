package andrey.murzin.core_ui.ext

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar

inline fun <reified T : ViewModel> Fragment.getViewModel(
    factory: ViewModelProvider.Factory
) = ViewModelProviders.of(this, factory).get(T::class.java)

fun Fragment.showMessage(message: String) {
    view?.let {
        Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show()
    }
}