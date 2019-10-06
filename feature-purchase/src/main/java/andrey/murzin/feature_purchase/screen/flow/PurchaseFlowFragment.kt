package andrey.murzin.feature_purchase.screen.flow

import andrey.murzin.core.di.holder.ActivityToolsHolder
import andrey.murzin.core_ui.base.BaseFlowFragment
import andrey.murzin.feature_purchase.R
import andrey.murzin.feature_purchase.screen.flow.di.PurchaseFlowComponent
import andrey.murzin.feature_purchase.screen.flow.provider.PurchaseFlowHolder
import andrey.murzin.feature_purchase.screen.flow.provider.PurchaseFlowProvider

class PurchaseFlowFragment : BaseFlowFragment(), PurchaseFlowHolder {

    override fun getContainer(): Int = R.id.containerFlow

    override fun inject() {
        getOrCreateComponent().inject(this)
    }

    override fun clearScope() {
        PurchaseFlowComponent.Initializer.componentInstance.clearInstance()
    }

    override fun getCurrentFlowProvider(): PurchaseFlowProvider = getOrCreateComponent()

    override fun getLayoutResId(): Int =
        R.layout.fragment_purchase_flow

    override fun initialScreen() {

    }

    private fun getOrCreateComponent(): PurchaseFlowComponent {
        val parentComponentHolder = activity as ActivityToolsHolder
        return PurchaseFlowComponent.Initializer.componentInstance.init(
            parentComponentHolder.getActivityToolsProvider()
        )
    }
}