package andrey.murzin.screen_currency.screen.flow.di.provider

import andrey.murzin.core.di.provider.MainToolsProvider
import andrey.murzin.feature_coin_detail.di.provider.CoinInfoProvider

data class CurrencyFlowInjector(
    val mainToolsProvider: MainToolsProvider,
    val coinInfoProvider: CoinInfoProvider
)