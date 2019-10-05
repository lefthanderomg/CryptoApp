package andrey.murzin.repository.entity

import andrey.murzin.core.model.CoinDetail
import andrey.murzin.core.model.USD
import andrey.murzin.core.model.Url

data class CoinDetailEntity(
    override val urlList: List<Url>? = null,
    override val logo: String? = null,
    override val id: Int? = null,
    override val name: String? = null,
    override val symbol: String? = null,
    override val slug: String? = null,
    override val description: String? = null,
    override val dateAdded: String? = null,
    override val usd: USD? = null
) : CoinDetail