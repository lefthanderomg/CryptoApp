package andrey.murzin.screen_currency.domain.usecase.coininfo

import andrey.murzin.core.model.CoinDetail
import andrey.murzin.core.repository.CoinRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetCoinInfoUseCaseImpl @Inject constructor(
    private val coinRepository: CoinRepository
) : GetCoinInfoUseCase {

    override fun getCoinInfo(id: Int): Observable<CoinDetail> =
        coinRepository.getCoinInfo(id)
}