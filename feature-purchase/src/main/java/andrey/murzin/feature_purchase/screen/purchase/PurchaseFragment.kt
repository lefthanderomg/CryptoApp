package andrey.murzin.feature_purchase.screen.purchase

import andrey.murzin.core.model.CoinDetail
import andrey.murzin.core.routing.FlowRouter
import andrey.murzin.core.utils.Logger
import andrey.murzin.core_ui.ViewModelOwnerFactory
import andrey.murzin.core_ui.base.BaseFragment
import andrey.murzin.core_ui.ext.*
import andrey.murzin.core_utils.argument
import andrey.murzin.feature_purchase.R
import andrey.murzin.feature_purchase.screen.flow.provider.PurchaseFlowHolder
import andrey.murzin.feature_purchase.screen.purchase.di.component.PurchaseComponent
import andrey.murzin.feature_purchase.screen.purchase.di.provider.PurchaseInjector
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_purchase.*
import javax.inject.Inject

class PurchaseFragment : BaseFragment() {

    companion object {
        private const val TAG = "PurchaseFragment"
        private const val ARG_ID = "ARG_ID"

        fun create(id: Int) = PurchaseFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_ID, id)
            }
        }
    }

    @Inject
    lateinit var flowRouter: FlowRouter

    @Inject
    lateinit var logger: Logger

    @Inject
    lateinit var viewModelOwnerFactory: ViewModelOwnerFactory

    private val idCoin by argument(ARG_ID, 0)

    private lateinit var viewModel: PurchaseViewModel

    override fun getLayoutResId(): Int = R.layout.fragment_purchase

    override fun onBackPressed() {
        flowRouter.finishFlow()
    }

    override fun inject() {
        getOrCreateComponent().inject(this)
    }

    override fun clearScope() {
        PurchaseComponent.Initializer.componentInstance.clearInstance()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = getViewModel(viewModelOwnerFactory)
        viewModel.purchaseLiveData().observe(
            viewLifecycleOwner,
            Observer {
                logger.d("$TAG $it")
                showLoad(it.loading)
                if (it.loading.not()) {
                    showRetry(it.loading)
                }
                showData(it.data, it.buyCoin)

            }
        )
        btnBuy.setOnClickListener {
            viewModel.onAction(CoinPurchaseAction.BuyCoin)
        }
    }

    private fun showLoad(flag: Boolean) {
        progressBar.setVisible(flag)
    }

    private fun showRetry(retry: Boolean) {
        btnRetry.setVisible(retry)
        btnBuy.setVisible(retry.not())
        tvCount.setVisible(retry.not())
    }

    private fun showData(data: CoinDetail?, buyCount: Int) {
        data?.let {
            context?.let {
                imgIcon.load(it, data.logo ?: "")
            }
            tvName.safeSetText(data.name ?: "")
            tvPrice.safeSetText(data.usd?.price?.toPrice() ?: "")
            tvCount.safeSetText(resources.getString(R.string.buy_coin, buyCount))
        }
    }

    private fun getOrCreateComponent(): PurchaseComponent {
        val parentComponentHolder = parentFragment as PurchaseFlowHolder
        return PurchaseComponent.Initializer.componentInstance.init(
            PurchaseInjector(
                parentComponentHolder.getCurrentFlowProvider(),
                idCoin
            )
        )
    }
}