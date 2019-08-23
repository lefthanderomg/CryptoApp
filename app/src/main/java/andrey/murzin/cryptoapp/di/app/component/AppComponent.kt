package andrey.murzin.cryptoapp.di.app.component

import andrey.murzin.cryptoapp.app.AppCrypto
import andrey.murzin.cryptoapp.di.app.provider.AppProvider
import andrey.murzin.cryptoapp.di.app.provider.DeviceProvider
import andrey.murzin.cryptoapp.di.app.provider.GlobalNavigationProvider
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [
        DeviceProvider::class,
        GlobalNavigationProvider::class
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

                val navigationProvider =
                    GlobalNavigationComponent.Initializer.init()

                return DaggerAppComponent.builder()
                    .deviceProvider(deviceToolsProvider)
                    .globalNavigationProvider(navigationProvider)
                    .build()
            }
        }
    }
}