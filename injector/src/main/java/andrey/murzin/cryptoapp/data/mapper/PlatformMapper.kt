package andrey.murzin.cryptoapp.data.mapper

import andrey.murzin.cryptoapp.data.model.PlatformModel
import andrey.murzin.cryptoapp.domain.entity.PlatformEntity
import javax.inject.Inject

class PlatformMapper @Inject constructor() {

    fun toEntity(platformModel: PlatformModel?): PlatformEntity? =
        platformModel?.let {
            PlatformEntity(
                it.id,
                it.name,
                it.slug,
                it.symbol,
                it.tokenAddress
            )
        }
}