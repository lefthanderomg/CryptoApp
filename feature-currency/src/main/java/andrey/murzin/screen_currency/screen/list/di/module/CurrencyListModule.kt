package andrey.murzin.screen_currency.screen.list.di.module

import andrey.murzin.core.di.scope.ScreenScope
import andrey.murzin.screen_currency.domain.usecase.coininfo.GetCoinInfoUseCase
import andrey.murzin.screen_currency.domain.usecase.coininfo.GetCoinInfoUseCaseImpl
import andrey.murzin.screen_currency.domain.usecase.currencylist.GetCurrencyListUseCase
import andrey.murzin.screen_currency.domain.usecase.currencylist.GetCurrencyListUseCaseImpl
import andrey.murzin.screen_currency.domain.usecase.savecoin.SaveCoinUseCase
import andrey.murzin.screen_currency.domain.usecase.savecoin.SaveCoinUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class CurrencyListModule {

    @Binds
    @ScreenScope
    abstract fun bindGetCurrencyListUseCase(
        getCurrencyListUseCase: GetCurrencyListUseCaseImpl
    ): GetCurrencyListUseCase

    @Binds
    @ScreenScope
    abstract fun bindSaveCoinUseCase(
        saveCoinUseCase: SaveCoinUseCaseImpl
    ): SaveCoinUseCase
}