package andrey.murzin.screen_currency.screen.detail.di.component

import andrey.murzin.screen_currency.screen.flow.di.provider.CurrencyFlowProvider

data class CoinDetailProvider(
    val currencyFlowProvider: CurrencyFlowProvider,
    val id: Int
)