package andrey.murzin.cryptoapp.di.app.component

import andrey.murzin.cryptoapp.app.AppCrypto
import andrey.murzin.cryptoapp.di.app.module.AppToolsModule
import andrey.murzin.cryptoapp.di.app.module.NetworkModule
import andrey.murzin.cryptoapp.di.app.provider.DeviceProvider
import com.google.gson.Gson
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        AppToolsModule::class,
        NetworkModule::class
    ]
)
@Singleton
interface DeviceToolsComponent : DeviceProvider {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: AppCrypto): DeviceToolsComponent
    }

    class Initializer private constructor() {
        companion object {
            fun init(app: AppCrypto): DeviceProvider =
                DaggerDeviceToolsComponent
                    .factory()
                    .create(app)
        }
    }
}