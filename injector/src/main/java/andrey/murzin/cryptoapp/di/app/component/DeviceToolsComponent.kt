package andrey.murzin.cryptoapp.di.app.component

import andrey.murzin.core.App
import andrey.murzin.cryptoapp.app.AppCrypto
import andrey.murzin.cryptoapp.di.app.module.AppToolsModule
import andrey.murzin.core.di.provider.DeviceProvider
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
        fun create(@BindsInstance app: App): DeviceToolsComponent
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