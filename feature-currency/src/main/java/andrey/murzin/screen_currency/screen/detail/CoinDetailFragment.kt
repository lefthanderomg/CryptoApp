package andrey.murzin.screen_currency.screen.detail

import andrey.murzin.core.model.CoinDetail
import andrey.murzin.core_ui.ViewModelOwnerFactory
import andrey.murzin.core_ui.base.BaseFragment
import andrey.murzin.core_ui.ext.*
import andrey.murzin.core_ui.model.ViewState
import andrey.murzin.core_utils.argument
import andrey.murzin.core.routing.FlowRouter
import andrey.murzin.screen_currency.R
import andrey.murzin.screen_currency.screen.detail.di.component.CoinDetailComponent
import andrey.murzin.screen_currency.screen.detail.di.provider.CoinDetailInjector
import andrey.murzin.screen_currency.screen.flow.di.provider.CurrencyFlowHolder
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_coin_detail.*
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
            CoinDetailInjector(
                parentComponent.getCurrentFlowProvider(),
                idCoin
            )
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
        viewModel.getCoinInfoLiveData().observe(
            viewLifecycleOwner,
            Observer {
                when (it) {
                    is ViewState.Loading -> {
                        showLoad(true)
                    }
                    is ViewState.Data<CoinDetail> -> {
                        showData(it.data)
                        showLoad(false)
                    }
                    is ViewState.Error -> {
                        showLoad(false)
                        showMessage(it.message)
                    }
                }
            }
        )
        btnBuy.setOnClickListener {
            viewModel.buy()
        }
    }

    private fun showLoad(flag: Boolean) {
        progressBar.setVisible(flag)
        btnBuy.setVisible(flag.not())
    }

    private fun showData(data: CoinDetail) {
        context?.let {
            imgIcon.load(it, data.logo ?: "")
        }
        tvName.text = data.name ?: ""
        tvSymbol.text = data.symbol ?: ""
        tvPrice.text = data.usd?.price?.toPrice() ?: ""
        tvDescription.text = data.description ?: ""
    }
}