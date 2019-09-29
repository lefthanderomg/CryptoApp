package andrey.murzin.repository

import andrey.murzin.core.model.Coin
import andrey.murzin.core.model.CoinDetail
import andrey.murzin.core.repository.CoinRepository
import andrey.murzin.network.api.CoinMarketApi
import andrey.murzin.repository.mapper.CoinDetailMapper
import andrey.murzin.repository.mapper.CoinMapper
import io.reactivex.Observable
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinMarketApi: CoinMarketApi,
    private val coinMapper: CoinMapper,
    private val coinDetailMapper: CoinDetailMapper
) : CoinRepository {

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

    override fun getCoinInfo(id: Int): Observable<CoinDetail> =
        coinMarketApi.getCoinInfo(id)
            .map { coinDetailMapper.toEntity(it) }
}