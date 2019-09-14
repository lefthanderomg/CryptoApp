package andrey.murzin.cryptoapp.presetation.feature.currency.list.di.component

import andrey.murzin.core.di.scope.ScreenScope
import andrey.murzin.cryptoapp.presetation.feature.currency.flow.di.provider.CurrencyFlowProvider
import andrey.murzin.cryptoapp.presetation.feature.currency.list.CurrencyListFragment
import andrey.murzin.cryptoapp.presetation.feature.currency.list.di.module.CurrencyListModule
import andrey.murzin.cryptoapp.presetation.feature.currency.list.di.module.ViewModelCurrencyListFactoryModule
import andrey.murzin.cryptoapp.tools.singleton.SingletonHolder
import dagger.Component


@Component(
    dependencies = [
        CurrencyFlowProvider::class
    ],
    modules = [
        CurrencyListModule::class,
        ViewModelCurrencyListFactoryModule::class
    ]
)
@ScreenScope
abstract class CurrencyListComponent {

    abstract fun inject(fragment: CurrencyListFragment)

    @Component.Factory
    interface Factory {
        fun create(provider: CurrencyFlowProvider): CurrencyListComponent
    }

    class Initializer private constructor() {
        companion object {
            val componentInstance: SingletonHolder<CurrencyListComponent, CurrencyFlowProvider> by lazy {
                SingletonHolder<CurrencyListComponent, CurrencyFlowProvider> {
                    DaggerCurrencyListComponent.factory()
                        .create(it)
                }
            }
        }
    }
}