package andrey.murzin.repository.entity

import andrey.murzin.core.model.Coin

data class CoinEntity(
    override val circulatingSupply: Double?,
    override val cmcRank: Int?,
    override val dateAdded: String?,
    override val id: Int?,
    override val lastUpdated: String?,
    override val maxSupply: Double?,
    override val name: String?,
    override val numMarketPairs: Int?,
    override val platform: PlatformEntity?,
    override val quote: QuoteEntity?,
    override val slug: String?,
    override val symbol: String?,
    override val tags: List<String?>?,
    override val totalSupply: Double?
) : Coin