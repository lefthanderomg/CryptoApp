package andrey.murzin.feature_purchase.screen.purchase.di.module

import andrey.murzin.core.di.scope.ScreenScope
import andrey.murzin.core_ui.ViewModelKey
import andrey.murzin.core_ui.ViewModelOwnerFactory
import andrey.murzin.feature_purchase.screen.purchase.PurchaseViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelPurchaseFactoryModule {

    @Binds
    @ScreenScope
    abstract fun bindViewModelFactory(
        viewModelOwnerFactory: ViewModelOwnerFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PurchaseViewModel::class)
    abstract fun bindCryptoCurrencyViewModel(
        coinDetailViewModel: PurchaseViewModel
    ): ViewModel
}