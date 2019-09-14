package andrey.murzin.cryptoapp.data.model


import com.google.gson.annotations.SerializedName

data class QuoteModel(
    @SerializedName("USD")
    val usd: USDModel?
)