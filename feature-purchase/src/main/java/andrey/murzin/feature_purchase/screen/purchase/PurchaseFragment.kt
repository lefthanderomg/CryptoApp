package andrey.murzin.feature_purchase.screen.purchase

import andrey.murzin.core.routing.FlowRouter
import andrey.murzin.core_ui.base.BaseFragment
import andrey.murzin.feature_purchase.R
import andrey.murzin.feature_purchase.screen.flow.provider.PurchaseFlowHolder
import andrey.murzin.feature_purchase.screen.purchase.di.component.PurchaseComponent
import andrey.murzin.feature_purchase.screen.purchase.di.provider.PurchaseInjector
import javax.inject.Inject

class PurchaseFragment : BaseFragment() {

    @Inject
    lateinit var flowRouter: FlowRouter

    override fun getLayoutResId(): Int = R.layout.fragment_purchase

    override fun onBackPressed() {
        flowRouter.exit()
    }

    override fun inject() {
        getOrCreateComponent().inject(this)
    }

    override fun clearScope() {
        PurchaseComponent.Initializer.componentInstance.clearInstance()
    }

    private fun getOrCreateComponent(): PurchaseComponent {
        val parentComponentHolder = parentFragment as PurchaseFlowHolder
        return PurchaseComponent.Initializer.componentInstance.init(
            PurchaseInjector(
                parentComponentHolder.getCurrentFlowProvider(),
                1
            )
        )
    }
}