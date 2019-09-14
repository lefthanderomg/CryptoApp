package andrey.murzin.cryptoapp.presetation.feature.currency.list.di.module

import andrey.murzin.core.di.scope.ScreenScope
import andrey.murzin.cryptoapp.domain.usecase.GetCurrencyListUseCase
import andrey.murzin.cryptoapp.domain.usecase.GetCurrencyListUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class CurrencyListModule {

    @Binds
    @ScreenScope
    abstract fun bindGetCurrencyListUseCase(
        GetCurrencyListUseCase: GetCurrencyListUseCaseImpl
    ): GetCurrencyListUseCase
}