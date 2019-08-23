package andrey.murzin.cryptoapp.presetation.feature.main.di.component

import andrey.murzin.cryptoapp.di.app.provider.AppProvider
import andrey.murzin.cryptoapp.di.scope.FeatureScope
import andrey.murzin.cryptoapp.presetation.feature.main.di.module.MainFeatureModule
import andrey.murzin.cryptoapp.presetation.feature.main.di.provider.MainToolsProvider
import andrey.murzin.cryptoapp.presetation.feature.main.view.MainActivity
import andrey.murzin.cryptoapp.tools.singleton.SingletonHolder
import dagger.Component

@Component(
    dependencies = [
        AppProvider::class
    ],
    modules = [
        MainFeatureModule::class
    ]
)
@FeatureScope
abstract class MainComponent : MainToolsProvider {

    abstract fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(appProvider: AppProvider): MainComponent
    }

    class Initializer private constructor() {
        companion object {
            val componentInstance: SingletonHolder<MainComponent, AppProvider> by lazy {
                SingletonHolder<MainComponent, AppProvider> {
                    DaggerMainComponent.factory()
                        .create(it)
                }
            }
        }
    }
}