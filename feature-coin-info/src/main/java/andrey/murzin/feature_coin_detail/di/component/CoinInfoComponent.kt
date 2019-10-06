package andrey.murzin.feature_coin_detail.di.component

import andrey.murzin.core.di.provider.AppProvider
import andrey.murzin.core.di.provider.MainToolsProvider
import andrey.murzin.core.di.scope.FlowScope
import andrey.murzin.core.di.scope.ScreenScope
import andrey.murzin.core.utils.singleton.SingletonHolder
import andrey.murzin.feature_coin_detail.di.module.CoinInfoModule
import andrey.murzin.feature_coin_detail.di.provider.CoinInfoProvider
import dagger.Component

@Component(
    dependencies = [AppProvider::class],
    modules = [CoinInfoModule::class]
)
@FlowScope
abstract class CoinInfoComponent : CoinInfoProvider {

    @Component.Factory
    interface Factory {
        fun create(
            appProvider: AppProvider
        ): CoinInfoComponent
    }

    class Initializer private constructor() {
        companion object {
            val componentInstance: SingletonHolder<CoinInfoComponent, AppProvider> by lazy {
                SingletonHolder<CoinInfoComponent, AppProvider> {
                    DaggerCoinInfoComponent.factory()
                        .create(it)
                }
            }
        }
    }
}