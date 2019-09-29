package andrey.murzin.network.deserializers

import andrey.murzin.network.ext.safeGetInt
import andrey.murzin.network.ext.safeGetJsonArray
import andrey.murzin.network.ext.safeGetJsonObject
import andrey.murzin.network.ext.safeGetString
import andrey.murzin.network.model.CoinDetailModel
import andrey.murzin.network.model.UrlModel
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

class CoinDetailDeserializer : JsonDeserializer<CoinDetailModel> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): CoinDetailModel {

        val jsonObject = json?.asJsonObject ?: return CoinDetailModel()

        val jsonData = jsonObject.safeGetJsonObject("data")
        jsonData?.keySet()?.firstOrNull()?.let { key ->
            val jsonCoinDetail = jsonData.safeGetJsonObject(key)

            return CoinDetailModel(
                id = jsonCoinDetail?.safeGetInt("id"),
                name = jsonCoinDetail?.safeGetString("name"),
                symbol = jsonCoinDetail?.safeGetString("symbol"),
                slug = jsonCoinDetail?.safeGetString("slug"),
                description = jsonCoinDetail?.safeGetString("description"),
                dateAdded = jsonCoinDetail?.safeGetString("date_added"),
                logo = jsonCoinDetail?.safeGetString("logo"),
                urlList = parseListUrls(jsonCoinDetail)
            )
        }

        return CoinDetailModel()
    }

    private fun parseListUrls(jsonCoinDetail: JsonObject?): List<UrlModel>? {
        return jsonCoinDetail?.let { json ->
            json.safeGetJsonObject("urls")?.let { jsonUrls ->
                val result = mutableListOf<UrlModel>()
                jsonUrls.keySet().forEach { key ->
                    result.add(
                        UrlModel(
                            name = key,
                            url = jsonUrls.safeGetJsonArray(key)?.toList()?.mapNotNull { url -> url?.asString }
                        )
                    )
                }
                return result
            }
        } ?: emptyList()
    }
}