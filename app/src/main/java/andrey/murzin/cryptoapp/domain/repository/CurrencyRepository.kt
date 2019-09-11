package andrey.murzin.cryptoapp.domain.repository

import andrey.murzin.cryptoapp.data.model.CurrencyDataModel
import io.reactivex.Observable

interface CurrencyRepository {
    fun getCurrencyList(): Observable<List<CurrencyDataModel?>>
}