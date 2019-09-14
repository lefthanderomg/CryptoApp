package andrey.murzin.repository.mapper

import andrey.murzin.network.model.QuoteModel
import andrey.murzin.repository.entity.QuoteEntity
import javax.inject.Inject

class QuoteMapper @Inject constructor(
    private val usdMapper: USDMapper
) {

    fun toEntity(quote: QuoteModel?): QuoteEntity? =
        quote?.let {
            QuoteEntity(usdMapper.toEntity(it.usd))
        }
}