package andrey.murzin.screen_currency.screen.detail.di

import andrey.murzin.core.di.scope.ScreenScope
import andrey.murzin.core.utils.singleton.SingletonHolder
import andrey.murzin.screen_currency.screen.detail.CoinDetailFragment
import andrey.murzin.screen_currency.screen.flow.di.provider.CurrencyFlowProvider
import andrey.murzin.screen_currency.screen.list.CurrencyListFragment
import andrey.murzin.screen_currency.screen.list.di.component.CurrencyListComponent
import andrey.murzin.screen_currency.screen.list.di.component.DaggerCurrencyListComponent
import dagger.Component

@Component(
    dependencies = [
        CurrencyFlowProvider::class
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