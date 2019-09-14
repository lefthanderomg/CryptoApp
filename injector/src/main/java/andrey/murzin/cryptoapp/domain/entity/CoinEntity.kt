package andrey.murzin.cryptoapp.domain.entity

data class CoinEntity(
    val circulatingSupply: Double?,
    val cmcRank: Int?,
    val dateAdded: String?,
    val id: Int?,
    val lastUpdated: String?,
    val maxSupply: Double?,
    val name: String?,
    val numMarketPairs: Int?,
    val platform: PlatformEntity?,
    val quote: QuoteEntity?,
    val slug: String?,
    val symbol: String?,
    val tags: List<String?>?,
    val totalSupply: Double?
)