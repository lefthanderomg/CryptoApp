package andrey.murzin.screen_currency

import andrey.murzin.screen_currency.screen.detail.CoinDetailFragment
import andrey.murzin.screen_currency.screen.list.CurrencyListFragment
import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen


object Screens {

    object CurrencyListScreen : SupportAppScreen() {
        override fun getFragment(): Fragment = CurrencyListFragment()
    }

    data class CoinDetailScreen(val id: Int) : SupportAppScreen(){
        override fun getFragment(): Fragment = CoinDetailFragment.create(id)
    }
}