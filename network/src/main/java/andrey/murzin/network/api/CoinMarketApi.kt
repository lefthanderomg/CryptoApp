package andrey.murzin.network.api

import andrey.murzin.network.model.CoinDetailModel
import andrey.murzin.network.model.CurrencyResultModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinMarketApi {

    @GET("cryptocurrency/listings/latest?start=1&limit=100&convert=USD")
    fun getCurrencyList(): Observable<CurrencyResultModel>

    @GET("cryptocurrency/info")
    fun getCoinInfo(@Query("id") id: Int): Observable<CoinDetailModel>
}