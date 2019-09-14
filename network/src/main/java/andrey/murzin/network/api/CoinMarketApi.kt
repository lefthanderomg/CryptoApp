package andrey.murzin.network.api

import andrey.murzin.network.model.CurrencyResultModel
import io.reactivex.Observable
import retrofit2.http.GET

interface CoinMarketApi {

    @GET("cryptocurrency/listings/latest?start=1&limit=100&convert=USD")
    fun getCurrencyList(): Observable<CurrencyResultModel>
}