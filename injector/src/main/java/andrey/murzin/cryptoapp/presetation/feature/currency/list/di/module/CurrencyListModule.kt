package andrey.murzin.cryptoapp.presetation.feature.currency.list.di.module

import andrey.murzin.cryptoapp.data.repository.CurrencyRepositoryImpl
import andrey.murzin.core.di.scope.ScreenScope
import andrey.murzin.core.di.repository.CurrencyRepository
import andrey.murzin.cryptoapp.domain.usecase.GetCurrencyListUseCase
import andrey.murzin.cryptoapp.domain.usecase.GetCurrencyListUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class CurrencyListModule {

    @Binds
    @ScreenScope
    abstract fun bindCurrencyRepository(
        currencyRepositoryImpl: CurrencyRepositoryImpl
    ): CurrencyRepository

    @Binds
    @ScreenScope
    abstract fun bindGetCurrencyListUseCase(
        GetCurrencyListUseCase: GetCurrencyListUseCaseImpl
    ): GetCurrencyListUseCase
}