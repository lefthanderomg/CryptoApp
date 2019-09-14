package andrey.murzin.network.di.component

import andrey.murzin.core.di.provider.DeviceProvider
import andrey.murzin.network.di.module.NetworkModule
import andrey.murzin.network.di.provider.NetworkProvider
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [DeviceProvider::class],
    modules = [NetworkModule::class]
)
@Singleton
interface NetworkComponent : NetworkProvider