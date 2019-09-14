package andrey.murzin.screen_currency.list.di.module

import andrey.murzin.core.di.scope.ScreenScope
import andrey.murzin.screen_currency.domain.usecase.GetCurrencyListUseCase
import andrey.murzin.screen_currency.domain.usecase.GetCurrencyListUseCaseImpl
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