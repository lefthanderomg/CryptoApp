package andrey.murzin.cryptoapp.presetation.feature.currency.list

import andrey.murzin.cryptoapp.domain.usecase.GetCurrencyListUseCaseImpl
import andrey.murzin.cryptoapp.tools.logger.Logger
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CurrencyListViewModel @Inject constructor(
    private val getCurrencyListUseCase: GetCurrencyListUseCaseImpl,
    private val logger: Logger
) : ViewModel() {

    companion object {
        private const val TAG = "CryptoCurrencyViewModel"
    }

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getCurrencyList() {
        getCurrencyListUseCase.getCurrencyList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                logger.d("$TAG getCurrencyList Success")
            }, {
                logger.d("$TAG getCurrencyList ${it.message ?: "Error"} ")
            }).also {
                compositeDisposable.add(it)
            }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}