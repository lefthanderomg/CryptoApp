package andrey.murzin.screen_currency.list

import andrey.murzin.core.model.Coin
import andrey.murzin.screen_currency.domain.usecase.GetCurrencyListUseCaseImpl
import andrey.murzin.core_ui.base.BaseViewModel
import andrey.murzin.core_ui.model.ViewState
import andrey.murzin.core.utils.Logger
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class CurrencyListViewModel @Inject constructor(
    private val getCurrencyListUseCase: GetCurrencyListUseCaseImpl,
    private val logger: Logger
) : BaseViewModel() {

    companion object {
        private const val TAG = "CryptoCurrencyViewModel"
    }

    private val refreshSignal = PublishSubject.create<Unit>()

    private val liveDataMap: MutableLiveData<ViewState<List<Coin>>> by lazy {
        MutableLiveData<ViewState<List<Coin>>>()
    }

    init {
        getCurrencyList()
    }

    fun refreshData() {
        logger.d(TAG)
        refreshSignal.onNext(Unit)
    }

    fun getCurrency() = liveDataMap

    private fun getCurrencyList() {
        getCurrencyListUseCase.getCurrencyList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { ViewState.Data<List<Coin>>(it) as ViewState<List<Coin>> }
            .startWith(ViewState.Loading())
            .repeatWhen { refreshSignal }
            .subscribe({
                liveDataMap.value = it
            }, {
                logger.d("$TAG ${it.printStackTrace()}")
            }).connect()
    }
}