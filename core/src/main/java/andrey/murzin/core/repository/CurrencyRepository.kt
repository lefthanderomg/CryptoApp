package andrey.murzin.core.repository

import andrey.murzin.core.model.Coin
import io.reactivex.Observable

interface CurrencyRepository {
    fun getCurrencyList(): Observable<List<Coin>>
}