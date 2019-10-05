package andrey.murzin.screen_currency.domain.usecase.savecoin

import andrey.murzin.core.model.Coin
import andrey.murzin.core.repository.CoinRepository
import io.reactivex.Completable
import javax.inject.Inject

class SaveCoinUseCaseImpl @Inject constructor(
    private val coinRepository: CoinRepository
) : SaveCoinUseCase {
    override fun saveCoin(coin: Coin): Completable =
        coinRepository.saveCoin(coin)
}