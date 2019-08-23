package andrey.murzin.cryptoapp.di.component

import andrey.murzin.cryptoapp.app.AppCrypto
import andrey.murzin.cryptoapp.di.module.AppToolsModule
import andrey.murzin.cryptoapp.di.provider.DeviceProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        AppToolsModule::class
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