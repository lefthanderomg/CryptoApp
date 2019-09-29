package andrey.murzin.core.repository

import andrey.murzin.core.model.Coin
import andrey.murzin.core.model.CoinDetail
import io.reactivex.Observable

interface CoinRepository {
    fun getCurrencyList(): Observable<List<Coin>>
    fun getCoinInfo(id: Int) : Observable<CoinDetail>
}