package andrey.murzin.repository.di.component

import andrey.murzin.core.di.provider.DeviceProvider
import andrey.murzin.core.di.provider.RepositoryProvider
import andrey.murzin.network.di.component.DaggerNetworkComponent
import andrey.murzin.network.di.provider.NetworkProvider
import andrey.murzin.repository.di.module.RepositoryModule
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [DeviceProvider::class, NetworkProvider::class],
    modules = [RepositoryModule::class]
)
@Singleton
interface RepositoryComponent : RepositoryProvider {
    class Initializer private constructor() {
        companion object {

            fun init(deviceProvider: DeviceProvider): RepositoryProvider {

                val networkProvider: NetworkProvider = DaggerNetworkComponent.builder()
                    .deviceProvider(deviceProvider)
                    .build()

                return DaggerRepositoryComponent.builder()
                    .deviceProvider(deviceProvider)
                    .networkProvider(networkProvider)
                    .build()
            }
        }
    }
}