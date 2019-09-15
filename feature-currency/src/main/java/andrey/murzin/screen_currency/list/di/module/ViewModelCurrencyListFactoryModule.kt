package andrey.murzin.screen_currency.list.di.module

import andrey.murzin.core_ui.ViewModelOwnerFactory
import andrey.murzin.core_ui.ViewModelKey
import andrey.murzin.core.di.scope.ScreenScope
import andrey.murzin.screen_currency.list.CurrencyListViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelCurrencyListFactoryModule {

    @Binds
    @ScreenScope
    abstract fun bindViewModelFactory(
        viewModelOwnerFactory: ViewModelOwnerFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CurrencyListViewModel::class)
    abstract fun bindCryptoCurrencyViewModel(
        cryptoCurrencyViewModel: CurrencyListViewModel
    ): ViewModel
}