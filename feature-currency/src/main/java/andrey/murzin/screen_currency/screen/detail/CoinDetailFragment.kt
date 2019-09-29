package andrey.murzin.screen_currency.screen.detail

import andrey.murzin.core_ui.ViewModelOwnerFactory
import andrey.murzin.core_ui.base.BaseFragment
import andrey.murzin.core_ui.ext.getViewModel
import andrey.murzin.core_utils.argument
import andrey.murzin.screen_currency.FlowRouter
import andrey.murzin.screen_currency.R
import andrey.murzin.screen_currency.screen.detail.di.component.CoinDetailComponent
import andrey.murzin.screen_currency.screen.flow.di.provider.CurrencyFlowHolder
import andrey.murzin.screen_currency.screen.list.CurrencyListViewModel
import android.os.Bundle
import android.view.View
import javax.inject.Inject

class CoinDetailFragment : BaseFragment() {

    companion object {

        private const val ID_ARG = "ID_ARG"

        fun create(id: Int) = CoinDetailFragment().apply {
            arguments = Bundle().apply {
                putInt(ID_ARG, id)
            }
        }
    }

    @Inject
    lateinit var flowRouter: FlowRouter

    @Inject
    lateinit var viewModelOwnerFactory: ViewModelOwnerFactory

    private lateinit var viewModel: CoinDetailViewModel

    private val idCoin by argument(ID_ARG, 0)

    override fun getLayoutResId(): Int = R.layout.fragment_coin_detail

    override fun inject() {
        val parentComponent = parentFragment as CurrencyFlowHolder
        CoinDetailComponent.Initializer.componentInstance.init(
            parentComponent.getCurrentFlowProvider()
        ).inject(this)
    }

    override fun clearScope() {
        CoinDetailComponent.Initializer.componentInstance.clearInstance()
    }

    override fun onBackPressed() {
        flowRouter.exit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = getViewModel(viewModelOwnerFactory)
        viewModel.getCoinInfo(idCoin)
    }
}