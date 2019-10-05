package andrey.murzin.repository.mapper

import andrey.murzin.core.model.Coin
import andrey.murzin.core.model.CoinDetail
import andrey.murzin.network.model.CoinDetailModel
import andrey.murzin.repository.entity.CoinDetailEntity
import javax.inject.Inject

class CoinDetailMapper @Inject constructor(
    private val urlMapper: UrlMapper
) : BaseMapper<CoinDetailModel, CoinDetail>() {

    override fun toEntity(
        data: CoinDetailModel,
        coin: Coin
    ): CoinDetail =
        CoinDetailEntity(
            id = data.id,
            logo = data.logo,
            name = data.name,
            symbol = data.symbol,
            slug = data.slug,
            dateAdded = data.dateAdded,
            description = data.description,
            urlList = data.urlList?.map { url -> urlMapper.toEntity(url, coin) },
            usd = coin.quote?.usd
        )
}