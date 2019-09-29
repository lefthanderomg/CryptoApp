package andrey.murzin.network.ext

import com.google.gson.JsonArray
import com.google.gson.JsonObject

fun JsonObject.safeGetJsonObject(key: String): JsonObject? {
    return this[key]?.takeUnless { it.isJsonNull }?.asJsonObject
}

fun JsonObject.safeGetInt(key: String): Int? {
    return this[key]?.takeUnless { it.isJsonNull }?.asInt
}

fun JsonObject.safeGetString(key: String): String? {
    return this[key]?.takeUnless { it.isJsonNull }?.asString
}

fun JsonObject.safeGetJsonArray(key: String): JsonArray? {
    return this[key].takeUnless { it.isJsonNull }?.asJsonArray
}