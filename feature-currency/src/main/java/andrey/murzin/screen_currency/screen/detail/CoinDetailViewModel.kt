package andrey.murzin.screen_currency.screen.detail

import andrey.murzin.core.routing.StartPurchaseFlow
import andrey.murzin.core.utils.Logger
import andrey.murzin.core_ui.base.BaseViewModel
import andrey.murzin.feature_coin_detail.domain.GetCoinInfoUseCase
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
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

    private val coinDetailLiveData: MutableLiveData<CoinDetailViewState> by lazy {
        MutableLiveData<CoinDetailViewState>()
    }

    init {
        getCoinInfo(id)
    }

    fun getCoinInfoLiveData(): LiveData<CoinDetailViewState> = coinDetailLiveData

    fun buy() {
        startPurchaseFlow.start(id)
    }

    private fun getCoinInfo(id: Int) {
        getCoinInfoUseCase.getCoinInfo(id)
            .map {
                CoinDetailViewState(
                    data = it,
                    loading = false,
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
            .subscribe({}, {
                logger.d("$TAG getCoinInfo ${it.message}")
            }).connect()
    }
}