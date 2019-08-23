package andrey.murzin.cryptoapp.di.component

import andrey.murzin.cryptoapp.app.AppCrypto
import andrey.murzin.cryptoapp.di.provider.AppProvider
import andrey.murzin.cryptoapp.di.provider.DeviceProvider
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [
        DeviceProvider::class
    ]
)
@Singleton
interface AppComponent : AppProvider {

    fun inject(app: AppCrypto)

    class Initializer private constructor() {
        companion object {
            fun init(app: AppCrypto): AppComponent {
                val deviceToolsProvider = DeviceToolsComponent.Initializer.init(app)


                return DaggerAppComponent.builder()
                    .deviceProvider(deviceToolsProvider)
                    .build()
            }
        }
    }
}