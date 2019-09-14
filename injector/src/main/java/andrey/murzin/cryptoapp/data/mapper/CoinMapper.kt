package andrey.murzin.cryptoapp.data.mapper

import andrey.murzin.core.di.model.Coin
import andrey.murzin.cryptoapp.data.model.CoinModel
import andrey.murzin.cryptoapp.domain.entity.CoinEntity
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