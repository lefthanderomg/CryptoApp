package andrey.murzin.screen_currency.domain.usecase.currencylist

import andrey.murzin.core.model.Coin
import io.reactivex.Observable

interface GetCurrencyListUseCase {
    fun getCurrencyList(): Observable<List<Coin>>
}
