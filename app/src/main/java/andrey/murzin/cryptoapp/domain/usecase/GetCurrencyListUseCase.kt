package andrey.murzin.cryptoapp.domain.usecase

import io.reactivex.Single

interface GetCurrencyListUseCase{
    fun getCurrencyList() : Single<Any>
}
