package andrey.murzin.network.model

import com.google.gson.annotations.SerializedName

class BaseResponse<T>(
    @SerializedName("data")
    val result: List<T>
)