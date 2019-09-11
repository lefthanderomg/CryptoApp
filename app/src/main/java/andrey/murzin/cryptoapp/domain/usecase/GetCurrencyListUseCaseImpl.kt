package andrey.murzin.cryptoapp.domain.usecase

import andrey.murzin.cryptoapp.domain.entity.CoinEntity
import andrey.murzin.cryptoapp.domain.repository.CurrencyRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetCurrencyListUseCaseImpl @Inject constructor(
    private val currencyRepository: CurrencyRepository
) : GetCurrencyListUseCase {
    override fun getCurrencyList(): Observable<List<CoinEntity>> =
        currencyRepository.getCurrencyList()
}