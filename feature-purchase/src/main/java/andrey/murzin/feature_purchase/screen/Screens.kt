package andrey.murzin.feature_purchase.screen

import andrey.murzin.feature_purchase.screen.purchase.PurchaseFragment
import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    data class PurchaseScreen(val id: Int) : SupportAppScreen() {
        override fun getFragment(): Fragment = PurchaseFragment.create(id)
    }
}