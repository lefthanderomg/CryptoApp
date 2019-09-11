package andrey.murzin.cryptoapp.presetation.feature.currency.flow.di.component

import andrey.murzin.cryptoapp.di.feature.module.FlowNavigationModule
import andrey.murzin.cryptoapp.di.scope.FlowScope
import andrey.murzin.cryptoapp.presetation.feature.currency.flow.CurrencyFlowFragment
import andrey.murzin.cryptoapp.presetation.feature.currency.flow.di.provider.CurrencyFlowProvider
import andrey.murzin.cryptoapp.presetation.feature.currency.list.di.module.ViewModelCurrencyListFactoryModule
import andrey.murzin.cryptoapp.presetation.feature.main.di.provider.MainToolsProvider
import andrey.murzin.cryptoapp.tools.singleton.SingletonHolder
import dagger.Component


@Component(
    dependencies = [
        MainToolsProvider::class
    ],
    modules = [
        FlowNavigationModule::class
    ]
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