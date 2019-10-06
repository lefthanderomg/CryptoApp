package andrey.murzin.feature_purchase.screen

import andrey.murzin.feature_purchase.screen.purchase.PurchaseFragment
import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object PurchaseScreen : SupportAppScreen() {
        override fun getFragment(): Fragment = PurchaseFragment()
    }
}