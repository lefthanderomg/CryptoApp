package andrey.murzin.repository.entity

import andrey.murzin.core.model.Quote


data class QuoteEntity(
    override val usd: USDEntity?
) : Quote