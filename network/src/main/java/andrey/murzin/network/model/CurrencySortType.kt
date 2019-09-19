package andrey.murzin.network.model

enum class CurrencySortType(val type: String) {
    MARKET_CAP("market_cap"),
    NAME("name"),
    SYMBOL("symbol"),
    DATE_ADDED("date_added"),
    market_cap_strict("market_cap_strict"),
    circulating_supply("circulating_supply"),
    price("price"),
    total_supply("total_supply"),
    max_supply("max_supply"),
    num_market_pairs("num_market_pairs"),
    volume_24h("volume_24h"),
    percent_change_1h("percent_change_1h"),
    percent_change_24h("percent_change_24h"),
    percent_change_7d("percent_change_7d"),
    market_cap_by_total_supply_strict("market_cap_by_total_supply_strict"),
    volume_7d("volume_7d"),
    volume_30d("volume_30d")
}
