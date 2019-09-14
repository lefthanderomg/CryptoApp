package andrey.murzin.cryptoapp.domain.entity

import andrey.murzin.core.di.model.Quote


data class QuoteEntity(
    override val usd: USDEntity?
) : Quote