package andrey.murzin.cryptoapp.data.network

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Header

interface CoinMarketApi {

    @GET("cryptocurrency/listings/latest?start=101&limit=100&convert=USD")
    fun getCurrencyList(): Single<ResponseBody>
}