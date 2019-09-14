package andrey.murzin.cryptoapp.domain.usecase

import andrey.murzin.cryptoapp.domain.entity.CoinEntity
import io.reactivex.Observable

interface GetCurrencyListUseCase {
    fun getCurrencyList(): Observable<List<CoinEntity>>
}
