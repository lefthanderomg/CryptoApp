package andrey.murzin.cryptoapp.presetation.feature.cryptocurrency

import andrey.murzin.cryptoapp.R
import andrey.murzin.cryptoapp.presetation.base.BaseFragment
import andrey.murzin.cryptoapp.presetation.base.FragmentBottomNavigationToolsHolder
import andrey.murzin.cryptoapp.presetation.feature.cryptocurrency.di.component.CryptoCurrencyComponent
import andrey.murzin.cryptoapp.presetation.feature.tool.ext.getViewModel
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class CryptoCurrencyFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var cryptoCurrencyViewModel: CryptoCurrencyViewModel

    override fun getLayoutResId(): Int = R.layout.fragment_cryptocurrency

    override fun clearScope() {
        CryptoCurrencyComponent.Initializer.componentInstance.clearInstance()
    }

    override fun inject() {
        val parentComponentHolder = parentFragment as FragmentBottomNavigationToolsHolder
        CryptoCurrencyComponent.Initializer.componentInstance.init(
            parentComponentHolder.getBottomNavigationToolsProvider()
        ).apply {
            inject(this@CryptoCurrencyFragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cryptoCurrencyViewModel = getViewModel(viewModelFactory)
        cryptoCurrencyViewModel.getCurrencyList()
    }
}