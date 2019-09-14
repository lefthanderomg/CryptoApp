package andrey.murzin.screen_main

import andrey.murzin.screen_bottomnav.BottomNavigationFragment
import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object BottomNavigationFlow : SupportAppScreen() {
        override fun getFragment(): Fragment =
            BottomNavigationFragment()
    }

//    object ExchangeTab : SupportAppScreen() {
//        override fun getFragment(): Fragment = ExchangeFragment()
//    }
//
//    object CurrencyTab : SupportAppScreen() {
//        override fun getFragment(): Fragment =
//            CurrencyFlowFragment()
//    }
//
//    object CurrencyListScreen : SupportAppScreen() {
//        override fun getFragment(): Fragment = CurrencyListFragment()
//    }
//
//    object MetricTab : SupportAppScreen() {
//        override fun getFragment(): Fragment = MetricFragment()
//    }
//
//    object PartnerTab : SupportAppScreen() {
//        override fun getFragment(): Fragment = PartnerFragment()
//    }
//
//    object ToolsTab : SupportAppScreen() {
//        override fun getFragment(): Fragment =
//            ToolFragment()
//    }
}