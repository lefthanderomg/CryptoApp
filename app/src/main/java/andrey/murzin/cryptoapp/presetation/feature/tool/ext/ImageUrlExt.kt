package andrey.murzin.cryptoapp.presetation.feature.tool.ext

private const val IMAGE_URL_32 = "https://s2.coinmarketcap.com/static/img/coins/32x32/%d.png"

fun Int.toImageUrl() : String =
    IMAGE_URL_32.format(this)
