package andrey.murzin.cryptoapp.domain.usecase

import andrey.murzin.cryptoapp.data.model.CurrencyDataModel
import andrey.murzin.cryptoapp.domain.repository.CurrencyRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class GetCurrencyListUseCaseImpl @Inject constructor(
    private val currencyRepository: CurrencyRepository
) : GetCurrencyListUseCase {
    override fun getCurrencyList(): Observable<List<CurrencyDataModel?>> = currencyRepository.getCurrencyList()
}