package andrey.murzin.feature_purchase.screen.flow

import andrey.murzin.core.di.holder.ActivityToolsHolder
import andrey.murzin.core_ui.base.BaseFlowFragment
import andrey.murzin.core_utils.argument
import andrey.murzin.feature_coin_detail.di.component.CoinInfoComponent
import andrey.murzin.feature_purchase.R
import andrey.murzin.feature_purchase.screen.Screens
import andrey.murzin.feature_purchase.screen.flow.di.PurchaseFlowComponent
import andrey.murzin.feature_purchase.screen.flow.provider.CoinInfoInjector
import andrey.murzin.feature_purchase.screen.flow.provider.PurchaseFlowHolder
import andrey.murzin.feature_purchase.screen.flow.provider.PurchaseFlowProvider
import andrey.murzin.feature_purchase.screen.purchase.PurchaseFragment
import android.os.Bundle

class PurchaseFlowFragment : BaseFlowFragment(), PurchaseFlowHolder {

    companion object {

        private const val ARG_ID = "ARG_ID"

        fun create(id: Int) = PurchaseFlowFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_ID, id)
            }
        }
    }

    private val idCoin by argument(ARG_ID, 0)

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
        flowRouter.newRootScreen(Screens.PurchaseScreen(idCoin))
    }

    private fun getOrCreateComponent(): PurchaseFlowComponent {
        val parentComponentHolder = activity as ActivityToolsHolder
        return PurchaseFlowComponent.Initializer.componentInstance.init(
            CoinInfoInjector(
                parentComponentHolder.getActivityToolsProvider(),
                CoinInfoComponent.Initializer.componentInstance.init(
                    parentComponentHolder.getActivityToolsProvider()
                )
            )
        )
    }
}