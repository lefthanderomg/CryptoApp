package andrey.murzin.repository.di.module

import andrey.murzin.core.repository.CoinRepository
import andrey.murzin.repository.CoinRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindCurrencyRepository(
        currencyRepositoryImpl: CoinRepositoryImpl
    ): CoinRepository
}