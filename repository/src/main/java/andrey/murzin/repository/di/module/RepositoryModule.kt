package andrey.murzin.repository.di.module

import andrey.murzin.core.repository.CoinRepository
import andrey.murzin.repository.CoinRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindCurrencyRepository(
        currencyRepositoryImpl: CoinRepositoryImpl
    ): CoinRepository
}