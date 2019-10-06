package andrey.murzin.feature_purchase.screen.purchase

import andrey.murzin.core_ui.base.BaseViewModel
import andrey.murzin.feature_coin_detail.domain.GetCoinInfoUseCase
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PurchaseViewModel @Inject constructor(
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    id: Int
) : BaseViewModel() {

    private val purchaseLiveData: MutableLiveData<CoinPurchaseViewState> by lazy {
        MutableLiveData<CoinPurchaseViewState>()
    }

    init {
        getCoinInfo(id)
    }

    fun purchaseLiveData(): LiveData<CoinPurchaseViewState> = purchaseLiveData

    private fun getCoinInfo(id: Int) {
        getCoinInfoUseCase.getCoinInfo(id)
            .map {
                CoinPurchaseViewState(
                    data = it,
                    loading = false,
                    error = ""
                )
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .startWith(CoinPurchaseViewState.createLoadingState())
            .onErrorReturn {
                CoinPurchaseViewState.createErrorState(it.message ?: "")
            }
            .doOnNext { purchaseLiveData.value = it }
            .subscribe().connect()
    }

    fun buy() {

    }
}