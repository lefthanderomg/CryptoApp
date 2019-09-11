package andrey.murzin.cryptoapp.presetation.feature.tool.ext

private const val IMAGE_URL_32 = "https://s2.coinmarketcap.com/static/img/coins/64x64/%d.png"

fun Int.toImageUrl() : String =
    IMAGE_URL_32.format(this)

fun Double.toPrice() : String =
    String.format("%.${2}f $", this)