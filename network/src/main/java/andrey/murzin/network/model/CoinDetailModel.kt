package andrey.murzin.network.model

import andrey.murzin.network.deserializers.CoinDetailDeserializer
import com.google.gson.annotations.JsonAdapter

@JsonAdapter(CoinDetailDeserializer::class)
data class CoinDetailModel(
    val urlList: List<UrlModel>? = null,
    val logo: String? = null,
    val id: Int? = null,
    val name: String? = null,
    val symbol: String? = null,
    val slug: String? = null,
    val description: String? = null,
    val dateAdded: String? = null
)