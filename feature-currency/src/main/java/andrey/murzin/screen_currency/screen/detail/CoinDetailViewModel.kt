package andrey.murzin.screen_currency.screen.detail

import andrey.murzin.core.utils.Logger
import andrey.murzin.core_ui.base.BaseViewModel
import andrey.murzin.screen_currency.domain.usecase.coininfo.GetCoinInfoUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CoinDetailViewModel @Inject constructor(
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    private val logger: Logger
) : BaseViewModel() {

    companion object {
        private const val TAG = "CoinDetailViewModel"
    }

    fun getCoinInfo(id: Int) {
        getCoinInfoUseCase.getCoinInfo(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                logger.d("$TAG getCoinInfo Success")
            }, {
                logger.d("$TAG getCoinInfo Error = ${it.message}")
            }).connect()
    }
}