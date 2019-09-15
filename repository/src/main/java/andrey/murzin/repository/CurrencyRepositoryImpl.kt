package andrey.murzin.repository

import andrey.murzin.core.model.Coin
import andrey.murzin.core.repository.CurrencyRepository
import andrey.murzin.network.api.CoinMarketApi
import andrey.murzin.repository.mapper.CoinMapper
import io.reactivex.Observable
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val coinMarketApi: CoinMarketApi,
    private val coinMapper: CoinMapper
) : CurrencyRepository {

    override fun getCurrencyList(): Observable<List<Coin>> =
        coinMarketApi.getCurrencyList()
            .map {
                it.data
            }.map {
                it.mapNotNull { item -> item }
            }.flatMapIterable {
                it
            }.map {
                coinMapper.toEntity(it)
            }.toList()
            .toObservable()
}