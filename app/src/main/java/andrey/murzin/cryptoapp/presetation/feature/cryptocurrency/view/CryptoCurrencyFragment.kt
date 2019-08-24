package andrey.murzin.cryptoapp.presetation.feature.cryptocurrency.view

import andrey.murzin.cryptoapp.R
import andrey.murzin.cryptoapp.presetation.base.BaseFragment
import andrey.murzin.cryptoapp.presetation.base.FragmentBottomNavigationToolsHolder
import andrey.murzin.cryptoapp.presetation.feature.cryptocurrency.di.component.CryptoCurrencyComponent

class CryptoCurrencyFragment : BaseFragment() {

    override fun getLayoutResId(): Int = R.layout.fragment_cryptocurrency

    override fun clearScope() {
        CryptoCurrencyComponent.Initializer.componentInstance.clearInstance()
    }

    override fun inject() {
        val parentComponentHolder = parentFragment as FragmentBottomNavigationToolsHolder
        CryptoCurrencyComponent.Initializer.componentInstance.init(
            parentComponentHolder.getBottomNavigationToolsProvider()
        )
    }
}