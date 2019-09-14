package andrey.murzin.network.model


import com.google.gson.annotations.SerializedName

data class CurrencyResultModel(
    @SerializedName("data")
    val data: List<CoinModel?>?
)