package andrey.murzin.cryptoapp.di.app.provider

import andrey.murzin.cryptoapp.app.AppCrypto
import andrey.murzin.cryptoapp.data.network.CoinMarketApi
import andrey.murzin.cryptoapp.tools.logger.Logger

interface DeviceProvider {
    fun provideApp(): AppCrypto
    fun provideLogger(): Logger
    fun provideCoinMarketApi(): CoinMarketApi
}