package andrey.murzin.cryptoapp.presetation.feature.currency.list.di.module

import andrey.murzin.cryptoapp.di.feature.factory.ViewModelOwnerFactory
import andrey.murzin.cryptoapp.di.key.ViewModelKey
import andrey.murzin.cryptoapp.di.scope.ScreenScope
import andrey.murzin.cryptoapp.presetation.feature.currency.list.CurrencyListViewModel
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