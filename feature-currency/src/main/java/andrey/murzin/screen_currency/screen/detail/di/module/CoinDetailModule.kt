package andrey.murzin.screen_currency.screen.detail.di.module

import andrey.murzin.core.di.scope.ScreenScope
import andrey.murzin.screen_currency.domain.usecase.coininfo.GetCoinInfoUseCase
import andrey.murzin.screen_currency.domain.usecase.coininfo.GetCoinInfoUseCaseImpl
import andrey.murzin.screen_currency.screen.detail.CoinDetailFragment
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class CoinDetailModule {

    @Binds
    @ScreenScope
    abstract fun bindGetCoinInfoUseCase(
        getCoinInfoUseCase: GetCoinInfoUseCaseImpl
    ): GetCoinInfoUseCase
}