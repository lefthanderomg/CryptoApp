package andrey.murzin.cryptoapp.presetation.feature.bottomnavigation.di.module

import andrey.murzin.cryptoapp.di.feature.factory.ViewModelOwnerFactory
import andrey.murzin.cryptoapp.di.key.ViewModelKey
import andrey.murzin.cryptoapp.di.scope.FlowScope
import andrey.murzin.cryptoapp.presetation.feature.cryptocurrency.CryptoCurrencyViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelBottomNavigationFactoryModule {

    @Binds
    @FlowScope
    abstract fun bindViewModelFactory(
        viewModelOwnerFactory: ViewModelOwnerFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CryptoCurrencyViewModel::class)
    abstract fun bindCryptoCurrencyViewModel(
        cryptoCurrencyViewModel: CryptoCurrencyViewModel
    ): ViewModel
}