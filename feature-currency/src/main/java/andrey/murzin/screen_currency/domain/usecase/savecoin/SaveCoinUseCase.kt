package andrey.murzin.screen_currency.domain.usecase.savecoin

import andrey.murzin.core.model.Coin
import io.reactivex.Completable

interface SaveCoinUseCase {
    fun saveCoin(coin: Coin): Completable
}