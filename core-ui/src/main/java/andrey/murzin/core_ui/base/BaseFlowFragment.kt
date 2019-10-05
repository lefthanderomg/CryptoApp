package andrey.murzin.core_ui.base

import andrey.murzin.core.di.module.FlowNavigationModule
import andrey.murzin.core.routing.FlowRouter
import androidx.annotation.IdRes
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject
import javax.inject.Named

abstract class BaseFlowFragment : BaseFragment() {

    @Inject
    lateinit var flowRouter: FlowRouter

    @Inject
    @field:[Named(FlowNavigationModule.FlOW)]
    lateinit var navigatorHolder: NavigatorHolder

    @IdRes
    abstract fun getContainer(): Int

    private val navigator: Navigator by lazy {
        object : SupportAppNavigator(activity, childFragmentManager, getContainer()) {

        }
    }

    private val currentFragment: BaseFragment?
        get() = childFragmentManager.findFragmentById(getContainer()) as? BaseFragment

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: flowRouter.finishFlow()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.setNavigator(navigator)
    }
}