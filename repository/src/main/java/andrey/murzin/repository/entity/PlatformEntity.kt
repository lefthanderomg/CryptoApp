package andrey.murzin.repository.entity

import andrey.murzin.core.model.Platform


data class PlatformEntity(
    override val id: Int?,
    override val name: String?,
    override val slug: String?,
    override val symbol: String?,
    override val tokenAddress: String?
) : Platform