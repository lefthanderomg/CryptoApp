package andrey.murzin.core.model

interface CoinDetail {
    val urlList: List<Url>?
    val logo: String?
    val id: Int?
    val name: String?
    val symbol: String?
    val slug: String?
    val description: String?
    val dateAdded: String?
    val usd: USD?
}