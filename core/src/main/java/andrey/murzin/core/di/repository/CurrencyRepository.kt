package andrey.murzin.core.di.repository

import andrey.murzin.core.di.model.Coin
import io.reactivex.Observable

interface CurrencyRepository {
    fun getCurrencyList(): Observable<List<Coin>>
}