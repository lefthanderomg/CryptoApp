package andrey.murzin.feature_purchase.screen.purchase

import andrey.murzin.core.model.CoinDetail
import andrey.murzin.core_ui.base.BaseViewModel
import andrey.murzin.core_ui.base.StateLiveData
import andrey.murzin.core_ui.model.ViewState
import andrey.murzin.feature_coin_detail.domain.GetCoinInfoUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PurchaseViewModel @Inject constructor(
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    id: Int
) : BaseViewModel() {

    private val purchaseLiveData: StateLiveData<CoinDetail> by lazy {
        StateLiveData<CoinDetail>()
    }

    init {
        getCoinInfo(id)
    }

    fun purchaseLiveData() = purchaseLiveData

    private fun getCoinInfo(id: Int) {
        getCoinInfoUseCase.getCoinInfo(id)
            .map { ViewState.Data<CoinDetail>(it) as ViewState<CoinDetail> }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .startWith(ViewState.Loading())
            .onErrorReturn { ViewState.Error(it.message ?: "") }
            .doOnNext { purchaseLiveData.value = it }
            .subscribe({}, {
            }).connect()
    }
}