package andrey.murzin.network.model


import com.google.gson.annotations.SerializedName

data class QuoteModel(
    @SerializedName("USD")
    val usd: USDModel?
)