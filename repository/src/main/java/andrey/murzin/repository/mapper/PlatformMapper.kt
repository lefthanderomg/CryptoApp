package andrey.murzin.repository.mapper

import andrey.murzin.network.model.PlatformModel
import andrey.murzin.repository.entity.PlatformEntity
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