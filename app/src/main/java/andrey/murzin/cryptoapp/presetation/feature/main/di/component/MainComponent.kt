package andrey.murzin.cryptoapp.presetation.feature.main.di.component

import andrey.murzin.cryptoapp.di.provider.AppProvider
import andrey.murzin.cryptoapp.di.scope.FeatureScope
import andrey.murzin.cryptoapp.presetation.feature.main.di.module.MainFeatureModule
import andrey.murzin.cryptoapp.presetation.feature.main.di.provider.MainToolsProvider
import andrey.murzin.cryptoapp.presetation.feature.main.view.MainActivity
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
interface MainComponent : MainToolsProvider {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(appProvider: AppProvider): MainComponent
    }

    class Initializer private constructor() {
        companion object {
            fun init(appProvider: AppProvider): MainComponent {

                return DaggerMainComponent.factory().create(appProvider)
            }
        }
    }
}