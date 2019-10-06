package andrey.murzin.screen_currency.screen.detail

import andrey.murzin.core.routing.StartPurchaseFlow
import andrey.murzin.core.utils.Logger
import andrey.murzin.core_ui.base.BaseViewModel
import andrey.murzin.feature_coin_detail.domain.GetCoinInfoUseCase
import andrey.murzin.screen_currency.screen.list.CurrencyListViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class CoinDetailViewModel @Inject constructor(
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    private val logger: Logger,
    private val startPurchaseFlow: StartPurchaseFlow,
    private val id: Int
) : BaseViewModel() {

    companion object {
        private const val TAG = "CoinDetailViewModel"
    }

    private val retryDataSignal = PublishSubject.create<Unit>()

    private val coinDetailLiveData: MutableLiveData<CoinDetailViewState> by lazy {
        MutableLiveData<CoinDetailViewState>()
    }

    init {
        getCoinInfo(id)
    }

    fun getCoinInfoLiveData(): LiveData<CoinDetailViewState> = coinDetailLiveData

    fun onAction(action: CoinDetailAction) {
        when (action) {
            is CoinDetailAction.BuyCoin -> buy()
            is CoinDetailAction.Retry -> retryData()
        }
    }

    private fun retryData() {
        retryDataSignal.onNext(Unit)
    }

    private fun buy() {
        startPurchaseFlow.start(id)
    }

    private fun getCoinInfo(id: Int) {
        getCoinInfoUseCase.getCoinInfo(id)
            .map {
                CoinDetailViewState(
                    data = it,
                    loading = false,
                    retry = false,
                    error = ""
                )
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .startWith(CoinDetailViewState.createLoadingState())
            .onErrorReturn {
                CoinDetailViewState.createErrorState(it.message ?: "")
            }
            .doOnNext { coinDetailLiveData.value = it }
            .repeatWhen { retryDataSignal }
            .subscribe({}, {
                logger.d("$TAG getCoinInfo ${it.message}")
            }).connect()
    }
}