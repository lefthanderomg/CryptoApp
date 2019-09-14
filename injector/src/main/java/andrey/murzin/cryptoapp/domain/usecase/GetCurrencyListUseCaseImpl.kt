package andrey.murzin.cryptoapp.domain.usecase

import andrey.murzin.core.di.model.Coin
import andrey.murzin.cryptoapp.domain.entity.CoinEntity
import andrey.murzin.core.di.repository.CurrencyRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetCurrencyListUseCaseImpl @Inject constructor(
    private val currencyRepository: CurrencyRepository
) : GetCurrencyListUseCase {
    override fun getCurrencyList(): Observable<List<Coin>> =
        currencyRepository.getCurrencyList()
}