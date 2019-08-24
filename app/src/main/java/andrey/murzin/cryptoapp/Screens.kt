package andrey.murzin.cryptoapp

import andrey.murzin.cryptoapp.presetation.feature.bottomnavigation.BottomNavigationFragment
import andrey.murzin.cryptoapp.presetation.feature.cryptocurrency.CryptoCurrencyFragment
import andrey.murzin.cryptoapp.presetation.feature.exchange.view.ExchangeFragment
import andrey.murzin.cryptoapp.presetation.feature.metrics.view.MetricFragment
import andrey.murzin.cryptoapp.presetation.feature.partner.view.PartnerFragment
import andrey.murzin.cryptoapp.presetation.feature.tool.view.ToolFragment
import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object BottomNavigationFlow : SupportAppScreen() {
        override fun getFragment(): Fragment =
            BottomNavigationFragment()
    }

    object ExchangeTab : SupportAppScreen() {
        override fun getFragment(): Fragment = ExchangeFragment()
    }

    object CurrencyTab : SupportAppScreen() {
        override fun getFragment(): Fragment =
            CryptoCurrencyFragment()
    }

    object MetricTab : SupportAppScreen() {
        override fun getFragment(): Fragment = MetricFragment()
    }

    object PartnerTab : SupportAppScreen() {
        override fun getFragment(): Fragment = PartnerFragment()
    }

    object ToolsTab : SupportAppScreen() {
        override fun getFragment(): Fragment = ToolFragment()
    }
}