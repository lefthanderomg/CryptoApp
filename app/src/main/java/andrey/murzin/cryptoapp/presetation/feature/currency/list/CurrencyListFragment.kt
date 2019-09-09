package andrey.murzin.cryptoapp.presetation.feature.currency.list

import andrey.murzin.cryptoapp.R
import andrey.murzin.cryptoapp.presetation.base.BaseFragment
import andrey.murzin.cryptoapp.presetation.feature.currency.flow.di.provider.CurrencyFlowHolder
import andrey.murzin.cryptoapp.presetation.feature.currency.list.di.component.CurrencyListComponent
import android.os.Bundle
import android.view.View

class CurrencyListFragment : BaseFragment() {

    override fun getLayoutResId(): Int = R.layout.fragment_currency_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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