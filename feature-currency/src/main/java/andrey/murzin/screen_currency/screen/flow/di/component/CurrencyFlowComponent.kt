package andrey.murzin.screen_currency.screen.flow.di.component

import andrey.murzin.core.di.module.FlowNavigationModule
import andrey.murzin.core.di.provider.MainToolsProvider
import andrey.murzin.core.di.scope.FlowScope
import andrey.murzin.core.utils.singleton.SingletonHolder
import andrey.murzin.feature_coin_detail.di.provider.CoinInfoProvider
import andrey.murzin.screen_currency.screen.flow.CurrencyFlowFragment
import andrey.murzin.screen_currency.screen.flow.di.provider.CurrencyFlowInjector
import andrey.murzin.screen_currency.screen.flow.di.provider.CurrencyFlowProvider

import dagger.Component


@Component(
    dependencies = [
        MainToolsProvider::class,
        CoinInfoProvider::class],
    modules = [FlowNavigationModule::class]
)
@FlowScope
abstract class CurrencyFlowComponent : CurrencyFlowProvider {

    abstract fun inject(cryptoCurrencyFragment: CurrencyFlowFragment)

    @Component.Factory
    interface Factory {
        fun create(
            mainToolsProvider: MainToolsProvider,
            coinInfoProvider: CoinInfoProvider
        ): CurrencyFlowComponent
    }

    class Initializer private constructor() {
        companion object {
            val componentInstance: SingletonHolder<CurrencyFlowComponent, CurrencyFlowInjector> by lazy {
                SingletonHolder<CurrencyFlowComponent, CurrencyFlowInjector> {
                    DaggerCurrencyFlowComponent.factory()
                        .create(it.mainToolsProvider, it.coinInfoProvider)
                }
            }
        }
    }
}