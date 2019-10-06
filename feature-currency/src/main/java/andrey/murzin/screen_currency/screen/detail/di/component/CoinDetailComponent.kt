package andrey.murzin.screen_currency.screen.detail.di.component

import andrey.murzin.core.di.scope.ScreenScope
import andrey.murzin.core.utils.singleton.SingletonHolder
import andrey.murzin.feature_coin_detail.di.provider.CoinInfoProvider
import andrey.murzin.screen_currency.screen.detail.CoinDetailFragment
import andrey.murzin.screen_currency.screen.detail.di.module.ViewModelCoinInfoFactoryModule
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
        fun create(provider: CurrencyFlowProvider, @BindsInstance kek: Int): CoinDetailComponent
    }

    class Initializer private constructor() {
        companion object {
            val componentInstance: SingletonHolder<CoinDetailComponent, CoinDetailProvider> by lazy {
                SingletonHolder<CoinDetailComponent, CoinDetailProvider> {
                    DaggerCoinDetailComponent.factory()
                        .create(it.currencyFlowProvider, it.id)
                }
            }
        }
    }
}