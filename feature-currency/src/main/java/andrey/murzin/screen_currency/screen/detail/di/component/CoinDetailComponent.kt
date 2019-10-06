package andrey.murzin.screen_currency.screen.detail.di.component

import andrey.murzin.core.di.scope.ScreenScope
import andrey.murzin.core.utils.singleton.SingletonHolder
import andrey.murzin.screen_currency.screen.detail.CoinDetailFragment
import andrey.murzin.screen_currency.screen.detail.di.module.ViewModelCoinInfoFactoryModule
import andrey.murzin.screen_currency.screen.detail.di.provider.CoinDetailInjector
import andrey.murzin.screen_currency.screen.flow.di.provider.CurrencyFlowProvider
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [
        CurrencyFlowProvider::class
    ],
    modules = [
        ViewModelCoinInfoFactoryModule::class
    ]
)
@ScreenScope
abstract class CoinDetailComponent {
    abstract fun inject(fragment: CoinDetailFragment)

    @Component.Factory
    interface Factory {
        fun create(provider: CurrencyFlowProvider, @BindsInstance id: Int): CoinDetailComponent
    }

    class Initializer private constructor() {
        companion object {
            val componentInstance: SingletonHolder<CoinDetailComponent, CoinDetailInjector> by lazy {
                SingletonHolder<CoinDetailComponent, CoinDetailInjector> {
                    DaggerCoinDetailComponent.factory()
                        .create(it.currencyFlowProvider, it.id)
                }
            }
        }
    }
}