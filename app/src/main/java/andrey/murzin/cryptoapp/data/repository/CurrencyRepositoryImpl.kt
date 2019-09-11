package andrey.murzin.cryptoapp.data.repository

import andrey.murzin.cryptoapp.data.mapper.CoinMapper
import andrey.murzin.cryptoapp.data.network.CoinMarketApi
import andrey.murzin.cryptoapp.domain.entity.CoinEntity
import andrey.murzin.cryptoapp.domain.repository.CurrencyRepository
import io.reactivex.Observable
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val coinMarketApi: CoinMarketApi,
    private val coinMapper: CoinMapper
) : CurrencyRepository {

    override fun getCurrencyList(): Observable<List<CoinEntity>> =
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