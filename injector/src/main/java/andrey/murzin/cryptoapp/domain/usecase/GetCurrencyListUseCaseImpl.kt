package andrey.murzin.cryptoapp.domain.usecase

import andrey.murzin.core.model.Coin
import andrey.murzin.core.repository.CurrencyRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetCurrencyListUseCaseImpl @Inject constructor(
    private val currencyRepository: CurrencyRepository
) : GetCurrencyListUseCase {
    override fun getCurrencyList(): Observable<List<Coin>> =
        currencyRepository.getCurrencyList()
}