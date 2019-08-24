package andrey.murzin.cryptoapp.presetation.feature.bottomnavigation.di.component

import andrey.murzin.cryptoapp.data.repository.CurrencyRepositoryImpl
import andrey.murzin.cryptoapp.di.scope.FlowScope
import andrey.murzin.cryptoapp.domain.repository.CurrencyRepository
import andrey.murzin.cryptoapp.domain.usecase.GetCurrencyListUseCase
import andrey.murzin.cryptoapp.domain.usecase.GetCurrencyListUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class CryptoCurrencyModule {

    @Binds
    @FlowScope
    abstract fun bindCurrencyRepository(
        currencyRepositoryImpl: CurrencyRepositoryImpl
    ): CurrencyRepository

    @Binds
    @FlowScope
    abstract fun bindGetCurrencyListUseCase(
        GetCurrencyListUseCase: GetCurrencyListUseCaseImpl
    ): GetCurrencyListUseCase
}