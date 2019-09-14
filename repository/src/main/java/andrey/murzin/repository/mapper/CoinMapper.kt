package andrey.murzin.repository.mapper

import andrey.murzin.core.model.Coin
import andrey.murzin.network.model.CoinModel
import andrey.murzin.repository.entity.CoinEntity

import javax.inject.Inject

class CoinMapper @Inject constructor(
    private val platformMapper: PlatformMapper,
    private val quoteMapper: QuoteMapper
) {
    fun toEntity(data: CoinModel): Coin = CoinEntity(
        data.circulatingSupply,
        data.cmcRank,
        data.dateAdded,
        data.id,
        data.lastUpdated,
        data.maxSupply,
        data.name,
        data.numMarketPairs,
        platformMapper.toEntity(data.platform),
        quoteMapper.toEntity(data.quote),
        data.slug,
        data.symbol,
        data.tags,
        data.totalSupply
    )
}