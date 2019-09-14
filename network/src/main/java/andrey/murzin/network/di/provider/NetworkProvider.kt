package andrey.murzin.network.di.provider

import andrey.murzin.network.api.CoinMarketApi

interface NetworkProvider {
    fun provideApi() : CoinMarketApi
}