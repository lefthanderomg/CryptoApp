package andrey.murzin.screen_currency

import andrey.murzin.screen_currency.list.CurrencyListFragment
import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen


object Screens {

    object CurrencyListScreen : SupportAppScreen() {
        override fun getFragment(): Fragment = CurrencyListFragment()
    }
}