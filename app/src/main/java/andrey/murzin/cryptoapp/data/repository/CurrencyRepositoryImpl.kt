package andrey.murzin.cryptoapp.data.repository

import andrey.murzin.cryptoapp.data.model.CurrencyDataModel
import andrey.murzin.cryptoapp.data.network.CoinMarketApi
import andrey.murzin.cryptoapp.domain.repository.CurrencyRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val coinMarketApi: CoinMarketApi
) : CurrencyRepository {

    override fun getCurrencyList(): Observable<List<CurrencyDataModel?>> =
        coinMarketApi.getCurrencyList()
            .map { it.data!! }
}