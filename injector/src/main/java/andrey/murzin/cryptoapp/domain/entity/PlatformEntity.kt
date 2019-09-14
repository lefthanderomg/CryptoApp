package andrey.murzin.cryptoapp.domain.entity

import andrey.murzin.core.di.model.Platform


data class PlatformEntity(
    override val id: Int?,
    override val name: String?,
    override val slug: String?,
    override val symbol: String?,
    override val tokenAddress: String?
) : Platform