package andrey.murzin.cryptoapp.di.app.component

import andrey.murzin.cryptoapp.di.app.module.GlobalNavigationModule
import andrey.murzin.cryptoapp.di.app.provider.GlobalNavigationProvider
import dagger.BindsInstance
import dagger.Component
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Component(
    modules = [GlobalNavigationModule::class]
)
@Singleton
interface GlobalNavigationComponent : GlobalNavigationProvider {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance cicerone: Cicerone<Router>): GlobalNavigationComponent
    }

    class Initializer private constructor() {
        companion object {
            fun init(): GlobalNavigationProvider =
                DaggerGlobalNavigationComponent
                    .factory()
                    .create(Cicerone.create())
        }
    }
}