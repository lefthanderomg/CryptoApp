package andrey.murzin.cryptoapp.domain.repository

import andrey.murzin.cryptoapp.domain.entity.CoinEntity
import io.reactivex.Observable

interface CurrencyRepository {
    fun getCurrencyList(): Observable<List<CoinEntity>>
}