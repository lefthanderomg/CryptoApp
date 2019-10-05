package andrey.murzin.repository.entity

import andrey.murzin.core.model.USD

data class USDEntity(
    override val lastUpdated: String?,
    override val marketCap: Double?,
    override val percentChange1h: Double?,
    override val percentChange24h: Double?,
    override val percentChange7d: Double?,
    override val price: Double?,
    override val volume24h: Double?
) : USD