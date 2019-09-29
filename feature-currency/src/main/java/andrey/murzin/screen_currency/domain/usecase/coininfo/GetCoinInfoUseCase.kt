package andrey.murzin.screen_currency.domain.usecase.coininfo

import andrey.murzin.core.model.CoinDetail
import io.reactivex.Observable

interface GetCoinInfoUseCase {
    fun getCoinInfo(id: Int) : Observable<CoinDetail>
}