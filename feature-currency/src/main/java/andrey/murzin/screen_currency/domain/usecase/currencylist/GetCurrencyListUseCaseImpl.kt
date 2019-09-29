package andrey.murzin.screen_currency.domain.usecase.currencylist

import andrey.murzin.core.model.Coin
import andrey.murzin.core.repository.CoinRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetCurrencyListUseCaseImpl @Inject constructor(
    private val currencyRepository: CoinRepository
) : GetCurrencyListUseCase {
    override fun getCurrencyList(): Observable<List<Coin>> =
        currencyRepository.getCurrencyList()
}