package andrey.murzin.feature_purchase.screen.flow.di

import andrey.murzin.core.di.module.FlowNavigationModule
import andrey.murzin.core.di.provider.MainToolsProvider
import andrey.murzin.core.di.scope.FlowScope
import andrey.murzin.core.utils.singleton.SingletonHolder
import andrey.murzin.feature_coin_detail.di.provider.CoinInfoProvider
import andrey.murzin.feature_purchase.screen.flow.PurchaseFlowFragment
import andrey.murzin.feature_purchase.screen.flow.provider.CoinInfoInjector
import andrey.murzin.feature_purchase.screen.flow.provider.PurchaseFlowProvider
import dagger.Component

@Component(
    dependencies = [MainToolsProvider::class,
        CoinInfoProvider::class],
    modules = [FlowNavigationModule::class]
)
@FlowScope
abstract class PurchaseFlowComponent : PurchaseFlowProvider {

    abstract fun inject(fragment: PurchaseFlowFragment)

    @Component.Factory
    interface Factory {
        fun create(
            mainToolsProvider: MainToolsProvider,
            coinInfoProvider: CoinInfoProvider
        ): PurchaseFlowComponent
    }

    class Initializer private constructor() {
        companion object {
            val componentInstance: SingletonHolder<PurchaseFlowComponent, CoinInfoInjector> by lazy {
                SingletonHolder<PurchaseFlowComponent, CoinInfoInjector> {
                    DaggerPurchaseFlowComponent.factory()
                        .create(it.mainToolsProvider, it.coinInfoProvider)
                }
            }
        }
    }
}