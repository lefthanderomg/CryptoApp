package andrey.murzin.repository.cache

import andrey.murzin.core.model.Coin
import andrey.murzin.core.model.CoinDetail
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.subjects.ReplaySubject
import javax.inject.Inject

class LocalCoinCache @Inject constructor() {

    private val coinCache: ReplaySubject<Coin> = ReplaySubject.createWithSize(1)
    private val coinDetailCache: ReplaySubject<CoinDetail> = ReplaySubject.createWithSize(1)

    fun saveCoin(coin: Coin): Completable =
        Completable.fromCallable {
            coinCache.onNext(coin)
        }

    fun saveCoinDetail(coinDetail: CoinDetail): Observable<CoinDetail> =
        Observable.fromCallable {
            coinDetailCache.onNext(coinDetail)
            coinDetail
        }

    fun getCoin() = coinCache

    fun getCoinDetail(id: Int): Observable<CoinDetail> =
        Observable.create { emitter ->
            if (emitter.isDisposed) return@create
            coinDetailCache.value?.let {
                if (id != it.id) emitter.onError(Throwable())
                emitter.onNext(it)
                emitter.onComplete()
            } ?: emitter.onError(Throwable())
        }

}