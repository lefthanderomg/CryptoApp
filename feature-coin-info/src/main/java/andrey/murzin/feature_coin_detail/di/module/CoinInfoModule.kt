package andrey.murzin.feature_coin_detail.di.module

import andrey.murzin.core.di.scope.FlowScope
import andrey.murzin.feature_coin_detail.domain.GetCoinInfoUseCase
import andrey.murzin.feature_coin_detail.domain.GetCoinInfoUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class CoinInfoModule {

    @Binds
    @FlowScope
    abstract fun bindGetCoinInfoUseCase(
        getCoinInfoUseCase: GetCoinInfoUseCaseImpl
    ): GetCoinInfoUseCase
}