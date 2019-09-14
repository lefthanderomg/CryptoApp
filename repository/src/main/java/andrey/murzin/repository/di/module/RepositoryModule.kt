package andrey.murzin.repository.di.module

import andrey.murzin.core.repository.CurrencyRepository
import andrey.murzin.repository.CurrencyRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindCurrencyRepository(
        currencyRepositoryImpl: CurrencyRepositoryImpl
    ): CurrencyRepository
}