package andrey.murzin.core_ui.ext

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

inline fun <reified T : ViewModel> Fragment.getViewModel(
    factory: ViewModelProvider.Factory
) = ViewModelProviders.of(this, factory).get(T::class.java)