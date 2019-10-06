package andrey.murzin.repository

import andrey.murzin.core.model.Coin
import andrey.murzin.core.model.CoinDetail
import andrey.murzin.core.repository.CoinRepository
import andrey.murzin.network.api.CoinMarketApi
import andrey.murzin.network.model.CoinDetailModel
import andrey.murzin.repository.cache.LocalCoinCache
import andrey.murzin.repository.mapper.CoinDetailMapper
import andrey.murzin.repository.mapper.CoinMapper
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.ReplaySubject
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinMarketApi: CoinMarketApi,
    private val coinMapper: CoinMapper,
    private val coinDetailMapper: CoinDetailMapper,
    private val localCoinCache: LocalCoinCache
) : CoinRepository {


    override fun saveCoin(coin: Coin): Completable = localCoinCache.saveCoin(coin)

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
        localCoinCache.getCoinDetail(id)
            .onErrorResumeNext(
                Observable.zip(
                    coinMarketApi.getCoinInfo(id),
                    localCoinCache.getCoin(),
                    BiFunction { coinDetailModel: CoinDetailModel, coin: Coin ->
                        return@BiFunction coinDetailMapper.toEntity(coinDetailModel, coin)
                    }
                ).flatMap {
                    localCoinCache.saveCoinDetail(it)
                }
            )
}