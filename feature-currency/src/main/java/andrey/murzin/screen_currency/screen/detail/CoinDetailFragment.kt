package andrey.murzin.screen_currency.screen.detail

import andrey.murzin.core.model.CoinDetail
import andrey.murzin.core.routing.FlowRouter
import andrey.murzin.core.utils.Logger
import andrey.murzin.core_ui.ViewModelOwnerFactory
import andrey.murzin.core_ui.base.BaseFragment
import andrey.murzin.core_ui.ext.*
import andrey.murzin.core_utils.argument
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
        private const val TAG = "CoinDetailFragment"
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

    @Inject
    lateinit var logger: Logger

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
                logger.d("$TAG $it")
                showLoad(it.loading)
                showData(it.data)
                if (it.loading.not()){
                    showRetry(it.retry)
                }
            }
        )
        btnBuy.setOnClickListener {
            viewModel.onAction(CoinDetailAction.BuyCoin)
        }
        btnRetry.setOnClickListener {
            viewModel.onAction(CoinDetailAction.Retry)
        }
    }

    private fun showLoad(flag: Boolean) {
        progressBar.setVisible(flag)
        if (flag) {
            btnBuy.setVisible(flag.not())
            btnRetry.setVisible(flag.not())
        }
    }

    private fun showRetry(retry: Boolean) {
        btnRetry.setVisible(retry)
        btnBuy.setVisible(retry.not())
    }

    private fun showData(data: CoinDetail?) {
        data?.let {
            context?.let {
                imgIcon.load(it, data.logo ?: "")
            }
            tvName.safeSetText(data.name ?: "")
            tvSymbol.safeSetText(data.symbol ?: "")
            tvPrice.safeSetText(data.usd?.price?.toPrice() ?: "")
            tvDescription.safeSetText(data.description ?: "")
        }
    }
}