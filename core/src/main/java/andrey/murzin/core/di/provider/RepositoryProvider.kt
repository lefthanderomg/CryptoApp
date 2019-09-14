package andrey.murzin.core.di.provider

import andrey.murzin.core.repository.CurrencyRepository

interface RepositoryProvider {
    fun providerCurrencyRepository(): CurrencyRepository
}