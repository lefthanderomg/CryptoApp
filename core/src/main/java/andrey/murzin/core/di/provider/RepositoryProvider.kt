package andrey.murzin.core.di.provider

import andrey.murzin.core.repository.CoinRepository

interface RepositoryProvider {
    fun providerCurrencyRepository(): CoinRepository
}