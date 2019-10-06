package andrey.murzin.feature_coin_detail.domain

import andrey.murzin.core.model.CoinDetail
import io.reactivex.Observable

interface GetCoinInfoUseCase {
    fun getCoinInfo(id: Int) : Observable<CoinDetail>
}