package andrey.murzin.screen_currency.screen.list

import andrey.murzin.core.model.Coin
import andrey.murzin.core.utils.Logger
import andrey.murzin.core_ui.base.BaseViewModel
import andrey.murzin.core_ui.base.StateLiveData
import andrey.murzin.core_ui.model.ViewState
import andrey.murzin.screen_currency.FlowRouter
import andrey.murzin.screen_currency.Screens
import andrey.murzin.screen_currency.domain.usecase.currencylist.GetCurrencyListUseCaseImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class CurrencyListViewModel @Inject constructor(
    private val getCurrencyListUseCase: GetCurrencyListUseCaseImpl,
    private val logger: Logger,
    private val flowRouter: FlowRouter
) : BaseViewModel() {

    companion object {
        private const val TAG = "CryptoCurrencyViewModel"
    }

    private val refreshSignal = PublishSubject.create<Unit>()

    private val currencyLiveData: StateLiveData<List<Coin>> by lazy {
        StateLiveData<List<Coin>>()
    }

    init {
        getCurrencyList()
    }

    fun refreshData() {
        logger.d(TAG)
        refreshSignal.onNext(Unit)
    }

    fun goCoinDetail(id: Int?) {
        id?.let {
            flowRouter.navigateTo(Screens.CoinDetailScreen(id))
        }
    }

    fun getCurrency() = currencyLiveData

    private fun getCurrencyList() {
        getCurrencyListUseCase.getCurrencyList()
            .map { ViewState.Data<List<Coin>>(it) as ViewState<List<Coin>> }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .startWith(ViewState.Loading())
            .onErrorReturn {
                logger.d("$TAG ${it.printStackTrace()}")
                ViewState.Error(it.message ?: "")
            }
            .doOnNext { currencyLiveData.value = it }
            .repeatWhen { refreshSignal }
            .subscribe().connect()
    }
}