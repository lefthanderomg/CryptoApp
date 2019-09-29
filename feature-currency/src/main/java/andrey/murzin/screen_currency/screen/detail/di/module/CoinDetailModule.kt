package andrey.murzin.screen_currency.screen.detail.di.module

import andrey.murzin.core.di.scope.ScreenScope
import andrey.murzin.screen_currency.domain.usecase.coininfo.GetCoinInfoUseCase
import andrey.murzin.screen_currency.domain.usecase.coininfo.GetCoinInfoUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class CoinDetailModule {

    @Binds
    @ScreenScope
    abstract fun bindGetCoinInfoUseCase(
        getCoinInfoUseCase: GetCoinInfoUseCaseImpl
    ): GetCoinInfoUseCase
}