package andrey.murzin.feature_purchase.screen.flow.provider

import andrey.murzin.core.di.provider.MainToolsProvider
import andrey.murzin.feature_coin_detail.di.provider.CoinInfoProvider

data class CoinInfoInjector(
    val mainToolsProvider: MainToolsProvider,
    val coinInfoProvider: CoinInfoProvider
)