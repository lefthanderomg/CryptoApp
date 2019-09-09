package andrey.murzin.cryptoapp.presetation.feature.currency.flow

import andrey.murzin.cryptoapp.R
import andrey.murzin.cryptoapp.Screens
import andrey.murzin.cryptoapp.di.feature.module.FlowNavigationModule
import andrey.murzin.cryptoapp.presetation.base.ActivityToolsHolder
import andrey.murzin.cryptoapp.presetation.base.BaseFragment
import andrey.murzin.cryptoapp.presetation.feature.currency.flow.di.component.CurrencyFlowComponent
import andrey.murzin.cryptoapp.presetation.feature.currency.flow.di.provider.CurrencyFlowHolder
import andrey.murzin.cryptoapp.presetation.feature.currency.flow.di.provider.CurrencyFlowProvider
import andrey.murzin.cryptoapp.tools.router.FlowRouter
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
        object : SupportAppNavigator(activity, childFragmentManager, R.id.container_flow) {

        }
    }

    override fun getLayoutResId(): Int = R.layout.fragment_cryptocurrency_flow

    override fun clearScope() {
        CurrencyFlowComponent.Initializer.componentInstance.clearInstance()
    }

    override fun inject() {
        getOrCreateComponent().inject(this)
    }

    override fun getCurrentFlowProvider(): CurrencyFlowProvider = getOrCreateComponent()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) flowRouter.newRootScreen(Screens.CurrencyListScreen)
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