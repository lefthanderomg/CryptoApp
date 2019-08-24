package andrey.murzin.cryptoapp.presetation.feature.cryptocurrency.di.component

import andrey.murzin.cryptoapp.di.scope.ScreenScope
import andrey.murzin.cryptoapp.presetation.feature.bottomnavigation.di.provider.BottomNavigationToolsProvider
import andrey.murzin.cryptoapp.tools.singleton.SingletonHolder
import dagger.Component


@Component(
    dependencies = [
        BottomNavigationToolsProvider::class
    ]
)
@ScreenScope
abstract class CryptoCurrencyComponent {

    @Component.Factory
    interface Factory {
        fun create(bottomToolsProvider: BottomNavigationToolsProvider): CryptoCurrencyComponent
    }

    class Initializer private constructor() {
        companion object {
            val componentInstance: SingletonHolder<CryptoCurrencyComponent, BottomNavigationToolsProvider> by lazy {
                SingletonHolder<CryptoCurrencyComponent, BottomNavigationToolsProvider> {
                    DaggerCryptoCurrencyComponent.factory()
                        .create(it)
                }
            }
        }
    }
}