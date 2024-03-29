package andrey.murzin.core_ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    @LayoutRes
    abstract fun getLayoutResId(): Int

    open fun inject() {}

    open fun clearScope() {}

    abstract fun onBackPressed()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(getLayoutResId(), container, false)

    override fun onDestroy() {
        super.onDestroy()
        if (needCloseScope()) {
            clearScope()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    private fun needCloseScope(): Boolean =
        when {
            activity?.isChangingConfigurations == true -> false
            else -> true
        }
}