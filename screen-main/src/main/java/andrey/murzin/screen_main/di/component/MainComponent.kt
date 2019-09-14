package andrey.murzin.screen_main.di.component

import andrey.murzin.core.di.provider.AppProvider
import andrey.murzin.screen_main.di.module.MainFeatureModule
import andrey.murzin.core.di.provider.MainToolsProvider
import andrey.murzin.screen_main.view.MainActivity
import andrey.murzin.core.utils.singleton.SingletonHolder
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [
        AppProvider::class
    ],
    modules = [
        MainFeatureModule::class,
        GlobalNavigationModule::class
    ]
)
@Singleton
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