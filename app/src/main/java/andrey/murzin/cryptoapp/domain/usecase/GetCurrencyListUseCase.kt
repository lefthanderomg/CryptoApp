package andrey.murzin.cryptoapp.domain.usecase

import andrey.murzin.cryptoapp.data.model.CurrencyDataModel
import io.reactivex.Observable

interface GetCurrencyListUseCase {
    fun getCurrencyList(): Observable<List<CurrencyDataModel?>>
}
