package andrey.murzin.cryptoapp.domain.repository

import io.reactivex.Single

interface CurrencyRepository {
    fun getCurrencyList(): Single<Any>
}