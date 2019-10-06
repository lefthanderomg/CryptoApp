package andrey.murzin.feature_purchase.screen.purchase

import andrey.murzin.core_ui.base.BaseViewModel
import andrey.murzin.feature_coin_detail.domain.GetCoinInfoUseCase

class PurchaseViewModel(
    private val getCoinInfoUseCase: GetCoinInfoUseCase
) : BaseViewModel() {

}