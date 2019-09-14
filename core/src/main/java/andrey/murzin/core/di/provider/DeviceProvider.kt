package andrey.murzin.core.di.provider

import andrey.murzin.core.App
import andrey.murzin.core.utils.Logger

interface DeviceProvider {
    fun provideApp(): App
    fun provideLogger(): Logger
}