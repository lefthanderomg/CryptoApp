package andrey.murzin.core.model

interface USD {
    val lastUpdated: String?
    val marketCap: Double?
    val percentChange1h: Double?
    val percentChange24h: Double?
    val percentChange7d: Double?
    val price: Double?
    val volume24h: Double?
}