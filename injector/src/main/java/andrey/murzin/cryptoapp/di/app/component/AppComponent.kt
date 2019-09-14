package andrey.murzin.cryptoapp.di.app.component

import andrey.murzin.core.di.provider.AppProvider
import andrey.murzin.core.di.provider.DeviceProvider
import andrey.murzin.core.di.provider.RepositoryProvider
import andrey.murzin.cryptoapp.app.AppCrypto
import andrey.murzin.cryptoapp.di.app.module.GlobalNavigationModule
import andrey.murzin.cryptoapp.di.app.provider.GlobalNavigationProvider
import andrey.murzin.repository.di.component.RepositoryComponent
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [
        DeviceProvider::class,
        RepositoryProvider::class
    ]
)
@Singleton
interface AppComponent : AppProvider {

    fun inject(app: AppCrypto)

    class Initializer private constructor() {
        companion object {
            fun init(app: AppCrypto): AppComponent {
                val deviceToolsProvider =
                    DeviceToolsComponent.Initializer.init(app)

                val repositoryProvider = RepositoryComponent.Initializer.init(
                    deviceToolsProvider
                )

                return DaggerAppComponent.builder()
                    .deviceProvider(deviceToolsProvider)
                    .repositoryProvider(repositoryProvider)
                    .build()
            }
        }
    }
}