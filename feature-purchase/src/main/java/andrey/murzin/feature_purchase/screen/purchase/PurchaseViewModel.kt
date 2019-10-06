package andrey.murzin.feature_purchase.screen.purchase

import andrey.murzin.core_ui.base.BaseViewModel
import andrey.murzin.feature_coin_detail.domain.GetCoinInfoUseCase
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class PurchaseViewModel @Inject constructor(
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    id: Int
) : BaseViewModel() {

    private val purchaseLiveData: MutableLiveData<CoinPurchaseViewState> by lazy {
        MutableLiveData<CoinPurchaseViewState>()
    }

    private val retryBuy = PublishSubject.create<Unit>()
    private val retryCoinInfo = PublishSubject.create<Unit>()

    init {
        getCoinInfo(id)
    }

    fun purchaseLiveData(): LiveData<CoinPurchaseViewState> = purchaseLiveData

    fun onAction(action: CoinPurchaseAction) {
        when (action) {
            is CoinPurchaseAction.Retry -> retry()
            is CoinPurchaseAction.BuyCoin -> buyCoin()
        }
    }

    private fun retry() {
        purchaseLiveData.value?.retry?.let {
            if (it.type == CoinPurchaseViewState.RetryType.COIN_INFO) {
                retryCoinInfo.onNext(Unit)
            } else {
                retryBuy.onNext(Unit)
            }
        }
    }

    private fun buyCoin() {
        val oldState = purchaseLiveData.value
        Observable.timer(300, TimeUnit.MILLISECONDS)
            .map {
                CoinPurchaseViewState.createDataState(
                    oldState?.data,
                    (oldState?.buyCoin ?: 0) + 1
                )
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .startWith(CoinPurchaseViewState.createLoadingState(oldState))
            .onErrorReturn {
                CoinPurchaseViewState.createErrorState(
                    it.message ?: "",
                    CoinPurchaseViewState.RetryType.BUY,
                    oldState
                )
            }
            .doOnNext { purchaseLiveData.value = it }
            .repeatWhen { retryBuy }
            .subscribe().connect()
    }

    private fun getCoinInfo(id: Int) {
        getCoinInfoUseCase.getCoinInfo(id)
            .map {
                CoinPurchaseViewState.createDataState(it)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .startWith(CoinPurchaseViewState.createLoadingState())
            .onErrorReturn {
                CoinPurchaseViewState.createErrorState(
                    it.message ?: "",
                    CoinPurchaseViewState.RetryType.COIN_INFO
                )
            }
            .doOnNext { purchaseLiveData.value = it }
            .repeatWhen { retryCoinInfo }
            .subscribe().connect()
    }
}