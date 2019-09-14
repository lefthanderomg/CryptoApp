package andrey.murzin.cryptoapp.presetation.model

import andrey.murzin.cryptoapp.Screens

sealed class BottomNavigationTab {
    val exchangeTab = Screens.ExchangeTab
    val currencyTab = Screens.CurrencyTab
    val metricTab = Screens.MetricTab
    val partnerTab = Screens.PartnerTab
    val toolsTab = Screens.ToolsTab
}