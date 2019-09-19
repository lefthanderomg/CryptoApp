package andrey.murzin.screen_currency.screen.list.di.component

import andrey.murzin.core.di.scope.ScreenScope
import andrey.murzin.core.utils.singleton.SingletonHolder
import andrey.murzin.screen_currency.screen.flow.di.provider.CurrencyFlowProvider
import andrey.murzin.screen_currency.screen.list.CurrencyListFragment
import andrey.murzin.screen_currency.screen.list.di.module.CurrencyListModule
import andrey.murzin.screen_currency.screen.list.di.module.ViewModelCurrencyListFactoryModule
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