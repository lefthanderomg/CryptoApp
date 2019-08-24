package andrey.murzin.cryptoapp.data.repository

import andrey.murzin.cryptoapp.data.network.CoinMarketApi
import andrey.murzin.cryptoapp.domain.repository.CurrencyRepository
import io.reactivex.Single
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val coinMarketApi: CoinMarketApi
) : CurrencyRepository {

    override fun getCurrencyList(): Single<Any> =
        coinMarketApi.getCurrencyList()
            .map { Any() }
}