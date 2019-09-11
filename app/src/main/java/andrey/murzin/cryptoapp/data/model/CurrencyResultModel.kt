package andrey.murzin.cryptoapp.data.model


import com.google.gson.annotations.SerializedName

data class CurrencyResultModel(
    @SerializedName("data")
    val data: List<CurrencyDataModel?>?
)