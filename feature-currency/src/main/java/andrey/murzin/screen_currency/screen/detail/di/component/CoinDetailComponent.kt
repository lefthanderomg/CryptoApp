package andrey.murzin.screen_currency.screen.detail.di.component

import andrey.murzin.core.di.scope.ScreenScope
import andrey.murzin.core.utils.singleton.SingletonHolder
import andrey.murzin.screen_currency.screen.detail.CoinDetailFragment
import andrey.murzin.screen_currency.screen.detail.di.module.CoinDetailModule
import andrey.murzin.screen_currency.screen.detail.di.module.ViewModelCoinInfoFactoryModule
import andrey.murzin.screen_currency.screen.flow.di.provider.CurrencyFlowProvider
import dagger.Component

@Component(
    dependencies = [
        CurrencyFlowProvider::class
    ],
    modules = [
        CoinDetailModule::class,
        ViewModelCoinInfoFactoryModule::class
    ]
)
@ScreenScope
abstract class CoinDetailComponent {
    abstract fun inject(fragment: CoinDetailFragment)

    @Component.Factory
    interface Factory {
        fun create(provider: CurrencyFlowProvider): CoinDetailComponent
    }

    class Initializer private constructor() {
        companion object {
            val componentInstance: SingletonHolder<CoinDetailComponent, CurrencyFlowProvider> by lazy {
                SingletonHolder<CoinDetailComponent, CurrencyFlowProvider> {
                    DaggerCoinDetailComponent.factory()
                        .create(it)
                }
            }
        }
    }
}