package andrey.murzin.screen_main

import andrey.murzin.feature_purchase.screen.flow.PurchaseFlowFragment
import andrey.murzin.screen_bottomnav.BottomNavigationFragment
import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object BottomNavigationFlow : SupportAppScreen() {
        override fun getFragment(): Fragment =
            BottomNavigationFragment()
    }

    data class PurchaseFlow(val id: Int) : SupportAppScreen() {
        override fun getFragment(): Fragment =
            PurchaseFlowFragment.create(id)
    }
}