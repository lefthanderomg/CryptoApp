package andrey.murzin.screen_currency.screen.detail.di.module

import andrey.murzin.core_ui.ViewModelOwnerFactory
import andrey.murzin.core_ui.ViewModelKey
import andrey.murzin.core.di.scope.ScreenScope
import andrey.murzin.screen_currency.screen.detail.CoinDetailViewModel
import andrey.murzin.screen_currency.screen.list.CurrencyListViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelCoinInfoFactoryModule {

    @Binds
    @ScreenScope
    abstract fun bindViewModelFactory(
        viewModelOwnerFactory: ViewModelOwnerFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CoinDetailViewModel::class)
    abstract fun bindCryptoCurrencyViewModel(
        coinDetailViewModel: CoinDetailViewModel
    ): ViewModel
}