package andrey.murzin.screen_currency.screen.detail

import andrey.murzin.core.model.CoinDetail
import andrey.murzin.core.routing.StartPurchaseFlow
import andrey.murzin.core.utils.Logger
import andrey.murzin.core_ui.base.BaseViewModel
import andrey.murzin.core_ui.base.StateLiveData
import andrey.murzin.core_ui.model.ViewState
import andrey.murzin.screen_currency.domain.usecase.coininfo.GetCoinInfoUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CoinDetailViewModel @Inject constructor(
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    private val logger: Logger,
    private val startPurchaseFlow: StartPurchaseFlow,
    id: Int
) : BaseViewModel() {

    companion object {
        private const val TAG = "CoinDetailViewModel"
    }

    private val coinDetailLiveData: StateLiveData<CoinDetail> by lazy {
        StateLiveData<CoinDetail>()
    }

    init {
        getCoinInfo(id)
    }

    fun getCoinInfoLiveData() = coinDetailLiveData

    fun buy() {
        startPurchaseFlow.start()
    }

    private fun getCoinInfo(id: Int) {
        getCoinInfoUseCase.getCoinInfo(id)
            .map { ViewState.Data<CoinDetail>(it) as ViewState<CoinDetail> }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .startWith(ViewState.Loading())
            .onErrorReturn { ViewState.Error(it.message ?: "") }
            .doOnNext { coinDetailLiveData.value = it }
            .subscribe({}, {
                logger.d("$TAG getCoinInfo ${it.message}")
            }).connect()
    }
}