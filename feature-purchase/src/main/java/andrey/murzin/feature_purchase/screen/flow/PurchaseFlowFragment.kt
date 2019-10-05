package andrey.murzin.feature_purchase.screen.flow

import andrey.murzin.core.di.holder.ActivityToolsHolder
import andrey.murzin.core.di.module.FlowNavigationModule
import andrey.murzin.core.routing.FlowRouter
import andrey.murzin.core_ui.base.BaseFragment
import andrey.murzin.feature_purchase.R
import andrey.murzin.feature_purchase.screen.flow.di.PurchaseFlowComponent
import andrey.murzin.feature_purchase.screen.flow.provider.PurchaseFlowHolder
import andrey.murzin.feature_purchase.screen.flow.provider.PurchaseFlowProvider
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject
import javax.inject.Named

class PurchaseFlowFragment : BaseFragment(), PurchaseFlowHolder {

    @Inject
    lateinit var flowRouter: FlowRouter

    @Inject
    @field:[Named(FlowNavigationModule.FlOW)]
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator: Navigator by lazy {
        object : SupportAppNavigator(activity, childFragmentManager, R.id.containerFlow) {

        }
    }

    private val currentFragment: BaseFragment?
        get() = childFragmentManager.findFragmentById(R.id.containerFlow) as? BaseFragment

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: flowRouter.finishFlow()
    }

    override fun inject() {
        getOrCreateComponent().inject(this)
    }

    override fun getCurrentFlowProvider(): PurchaseFlowProvider = getOrCreateComponent()

    override fun getLayoutResId(): Int =
        R.layout.fragment_purchase_flow

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.setNavigator(navigator)
    }

    private fun getOrCreateComponent(): PurchaseFlowComponent {
        val parentComponentHolder = activity as ActivityToolsHolder
        return PurchaseFlowComponent.Initializer.componentInstance.init(
            parentComponentHolder.getActivityToolsProvider()
        )
    }
}