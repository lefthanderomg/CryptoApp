package andrey.murzin.repository.mapper

import andrey.murzin.network.model.USDModel
import andrey.murzin.repository.entity.USDEntity
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