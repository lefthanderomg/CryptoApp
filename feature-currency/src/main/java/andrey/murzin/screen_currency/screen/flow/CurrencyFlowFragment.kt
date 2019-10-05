package andrey.murzin.screen_currency.screen.flow

import andrey.murzin.core.di.holder.ActivityToolsHolder
import andrey.murzin.core.di.module.FlowNavigationModule
import andrey.murzin.core_ui.base.BaseFragment
import andrey.murzin.screen_currency.screen.flow.di.component.CurrencyFlowComponent
import andrey.murzin.screen_currency.screen.flow.di.provider.CurrencyFlowHolder
import andrey.murzin.screen_currency.screen.flow.di.provider.CurrencyFlowProvider
import andrey.murzin.core.routing.FlowRouter
import andrey.murzin.screen_currency.R
import andrey.murzin.screen_currency.Screens
import android.os.Bundle
import android.view.View
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject
import javax.inject.Named

class CurrencyFlowFragment : BaseFragment(), CurrencyFlowHolder {

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

    override fun getLayoutResId(): Int = R.layout.fragment_cryptocurrency_flow

    override fun clearScope() {
        CurrencyFlowComponent.Initializer.componentInstance.clearInstance()
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: flowRouter.finishFlow()
    }

    override fun inject() {
        getOrCreateComponent().inject(this)
    }

    override fun getCurrentFlowProvider(): CurrencyFlowProvider = getOrCreateComponent()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (childFragmentManager.fragments.isEmpty()) {
            flowRouter.newRootScreen(Screens.CurrencyListScreen)
        }
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.setNavigator(navigator)
    }

    private fun getOrCreateComponent(): CurrencyFlowComponent {
        val parentComponentHolder = activity as ActivityToolsHolder
        return CurrencyFlowComponent.Initializer.componentInstance.init(
            parentComponentHolder.getActivityToolsProvider()
        )
    }
}