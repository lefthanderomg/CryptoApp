package andrey.murzin.cryptoapp.di.provider

import andrey.murzin.cryptoapp.app.AppCrypto
import andrey.murzin.cryptoapp.tools.logger.Logger

interface DeviceProvider {
    fun provideApp(): AppCrypto
    fun provideLogger(): Logger
}