package andrey.murzin.screen_currency.screen.detail.di.provider

import andrey.murzin.screen_currency.screen.flow.di.provider.CurrencyFlowProvider

data class CoinDetailInjector(
    val currencyFlowProvider: CurrencyFlowProvider,
    val id: Int
)