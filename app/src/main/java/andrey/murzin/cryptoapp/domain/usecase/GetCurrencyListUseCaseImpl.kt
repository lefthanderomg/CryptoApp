package andrey.murzin.cryptoapp.domain.usecase

import andrey.murzin.cryptoapp.domain.repository.CurrencyRepository
import io.reactivex.Single
import javax.inject.Inject

class GetCurrencyListUseCaseImpl @Inject constructor(
    private val currencyRepository: CurrencyRepository
) : GetCurrencyListUseCase {
    override fun getCurrencyList(): Single<Any> = currencyRepository.getCurrencyList()
}