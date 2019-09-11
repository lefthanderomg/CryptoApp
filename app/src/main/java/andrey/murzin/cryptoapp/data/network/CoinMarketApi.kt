package andrey.murzin.cryptoapp.data.network

import andrey.murzin.cryptoapp.data.model.CurrencyResultModel
import andrey.murzin.cryptoapp.presetation.feature.currency.list.CurrencyListViewModel
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Header

interface CoinMarketApi {

    @GET("cryptocurrency/listings/latest?start=1&limit=100&convert=USD")
    fun getCurrencyList(): Observable<CurrencyResultModel>
}