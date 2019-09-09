package andrey.murzin.cryptoapp.presetation.feature.currency.list

import andrey.murzin.cryptoapp.R
import andrey.murzin.cryptoapp.di.feature.factory.ViewModelOwnerFactory
import andrey.murzin.cryptoapp.presetation.base.BaseFragment
import andrey.murzin.cryptoapp.presetation.feature.currency.flow.di.provider.CurrencyFlowHolder
import andrey.murzin.cryptoapp.presetation.feature.currency.list.di.component.CurrencyListComponent
import andrey.murzin.cryptoapp.presetation.feature.tool.ext.getViewModel
import android.os.Bundle
import android.view.View
import javax.inject.Inject

class CurrencyListFragment : BaseFragment() {

    @Inject
    lateinit var viewModelOwnerFactory: ViewModelOwnerFactory

    private lateinit var viewModel: CurrencyListViewModel

    override fun getLayoutResId(): Int = R.layout.fragment_currency_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = getViewModel(viewModelOwnerFactory)
        viewModel.getCurrencyList()
    }

    override fun inject() {
        val parentComponent = parentFragment as CurrencyFlowHolder
        CurrencyListComponent.Initializer.componentInstance.init(
            parentComponent.getCurrentFlowProvider()
        ).inject(this)
    }

    override fun clearScope() {
        CurrencyListComponent.Initializer.componentInstance.clearInstance()
    }
}