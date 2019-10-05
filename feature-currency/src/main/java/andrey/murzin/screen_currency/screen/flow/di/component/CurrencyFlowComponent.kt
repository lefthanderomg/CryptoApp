package andrey.murzin.screen_currency.screen.flow.di.component

import andrey.murzin.core.di.module.FlowNavigationModule
import andrey.murzin.core.di.provider.MainToolsProvider
import andrey.murzin.core.di.scope.FlowScope
import andrey.murzin.core.utils.singleton.SingletonHolder
import andrey.murzin.screen_currency.screen.flow.CurrencyFlowFragment
import andrey.murzin.screen_currency.screen.flow.di.provider.CurrencyFlowProvider

import dagger.Component


@Component(
    dependencies = [MainToolsProvider::class],
    modules = [FlowNavigationModule::class]
)
@FlowScope
abstract class CurrencyFlowComponent : CurrencyFlowProvider {

    abstract fun inject(cryptoCurrencyFragment: CurrencyFlowFragment)

    @Component.Factory
    interface Factory {
        fun create(mainToolsProvider: MainToolsProvider): CurrencyFlowComponent
    }

    class Initializer private constructor() {
        companion object {
            val componentInstance: SingletonHolder<CurrencyFlowComponent, MainToolsProvider> by lazy {
                SingletonHolder<CurrencyFlowComponent, MainToolsProvider> {
                    DaggerCurrencyFlowComponent.factory()
                        .create(it)
                }
            }
        }
    }
}