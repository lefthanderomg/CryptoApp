package andrey.murzin.feature_coin_detail.di.provider

import andrey.murzin.feature_coin_detail.domain.GetCoinInfoUseCase

interface CoinInfoProvider {
    fun provideCoinInfoUseCase(): GetCoinInfoUseCase
}