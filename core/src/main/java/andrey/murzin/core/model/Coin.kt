package andrey.murzin.core.model

interface Coin {
    val circulatingSupply: Double?
    val cmcRank: Int?
    val dateAdded: String?
    val id: Int?
    val lastUpdated: String?
    val maxSupply: Double?
    val name: String?
    val numMarketPairs: Int?
    val platform: Platform?
    val quote: Quote?
    val slug: String?
    val symbol: String?
    val tags: List<String?>?
    val totalSupply: Double?
}