package andrey.murzin.cryptoapp.data.mapper

import andrey.murzin.cryptoapp.data.model.QuoteModel
import andrey.murzin.cryptoapp.domain.entity.QuoteEntity
import javax.inject.Inject

class QuoteMapper @Inject constructor(
    private val usdMapper: USDMapper
) {

    fun toEntity(quote: QuoteModel?): QuoteEntity? =
        quote?.let {
            QuoteEntity(usdMapper.toEntity(it.usd))
        }
}