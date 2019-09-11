package andrey.murzin.cryptoapp.presetation.feature.currency.list

import andrey.murzin.cryptoapp.data.model.CurrencyDataModel
import andrey.murzin.cryptoapp.domain.usecase.GetCurrencyListUseCaseImpl
import andrey.murzin.cryptoapp.presetation.base.BaseViewModel
import andrey.murzin.cryptoapp.presetation.model.ViewState
import andrey.murzin.cryptoapp.tools.logger.Logger
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

    private val liveDataMap: MutableLiveData<ViewState<List<CurrencyDataModel?>>> by lazy { MutableLiveData<ViewState<List<CurrencyDataModel?>>>() }

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
            .map { ViewState.Data<List<CurrencyDataModel?>>(it) as ViewState<List<CurrencyDataModel?>> }
            .startWith(ViewState.Loading())
            .repeatWhen { refreshSignal }
            .subscribe({
                liveDataMap.value = it
            }, {
                logger.d("$TAG ${it.printStackTrace()}")
            }).connect()
    }
}