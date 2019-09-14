package andrey.murzin.cryptoapp.data.mapper

import andrey.murzin.cryptoapp.data.model.USDModel
import andrey.murzin.cryptoapp.domain.entity.USDEntity
import javax.inject.Inject

class USDMapper @Inject constructor() {

    fun toEntity(from: USDModel?): USDEntity? =
        from?.let {
            USDEntity(
                it.lastUpdated,
                it.marketCap,
                it.percentChange1h,
                it.percentChange24h,
                it.percentChange7d,
                it.price,
                it.volume24h
            )
        }
}