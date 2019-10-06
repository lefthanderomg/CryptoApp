package andrey.murzin.feature_purchase.screen.purchase.di.component

import andrey.murzin.core.di.scope.ScreenScope
import andrey.murzin.core.utils.singleton.SingletonHolder
import andrey.murzin.feature_purchase.screen.flow.PurchaseFlowFragment
import andrey.murzin.feature_purchase.screen.flow.provider.PurchaseFlowProvider
import andrey.murzin.feature_purchase.screen.purchase.PurchaseFragment
import andrey.murzin.feature_purchase.screen.purchase.di.module.ViewModelPurchaseFactoryModule
import andrey.murzin.feature_purchase.screen.purchase.di.provider.PurchaseInjector
import dagger.BindsInstance
import dagger.Component


@Component(
    dependencies = [
        PurchaseFlowProvider::class
    ],
    modules = [
        ViewModelPurchaseFactoryModule::class
    ]
)
@ScreenScope
abstract class PurchaseComponent {

    abstract fun inject(fragment: PurchaseFragment)

    @Component.Factory
    interface Factory {
        fun create(provider: PurchaseFlowProvider, @BindsInstance id: Int): PurchaseComponent
    }

    class Initializer private constructor() {
        companion object {
            val componentInstance: SingletonHolder<PurchaseComponent, PurchaseInjector> by lazy {
                SingletonHolder<PurchaseComponent, PurchaseInjector> {
                    DaggerPurchaseComponent.factory()
                        .create(it.purchaseFlowProvider, it.id)
                }
            }
        }
    }
}