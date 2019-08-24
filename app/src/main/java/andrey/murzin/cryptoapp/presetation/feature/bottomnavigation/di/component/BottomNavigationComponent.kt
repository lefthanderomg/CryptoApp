package andrey.murzin.cryptoapp.presetation.feature.bottomnavigation.di.component

import andrey.murzin.cryptoapp.di.feature.module.FlowNavigationModule
import andrey.murzin.cryptoapp.di.scope.FeatureScope
import andrey.murzin.cryptoapp.presetation.feature.bottomnavigation.di.module.BottomNavigationModule
import andrey.murzin.cryptoapp.presetation.feature.bottomnavigation.di.provider.BottomNavigationToolsProvider
import andrey.murzin.cryptoapp.presetation.feature.bottomnavigation.view.BottomNavigationFragment
import andrey.murzin.cryptoapp.presetation.feature.main.di.provider.MainToolsProvider
import andrey.murzin.cryptoapp.tools.singleton.SingletonHolder
import dagger.Component

@Component(
    dependencies = [
        MainToolsProvider::class
    ],
    modules = [
        FlowNavigationModule::class,
        BottomNavigationModule::class
    ]
)
@FeatureScope
abstract class BottomNavigationComponent : BottomNavigationToolsProvider {

    abstract fun inject(bottomNavigationFragment: BottomNavigationFragment)

    @Component.Factory
    interface Factory {
        fun create(mainToolsProvider: MainToolsProvider): BottomNavigationComponent
    }

    class Initializer private constructor() {
        companion object {
            val componentInstance: SingletonHolder<BottomNavigationComponent, MainToolsProvider> by lazy {
                SingletonHolder<BottomNavigationComponent, MainToolsProvider> {
                    DaggerBottomNavigationComponent.factory()
                        .create(it)
                }
            }
        }
    }
}