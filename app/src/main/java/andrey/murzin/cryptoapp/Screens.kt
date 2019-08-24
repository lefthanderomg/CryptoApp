package andrey.murzin.cryptoapp

import andrey.murzin.cryptoapp.presetation.feature.bottomnavigation.view.BottomNavigationFragment
import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {
    object BottomNavigationFlow : SupportAppScreen() {
        override fun getFragment(): Fragment = BottomNavigationFragment()
    }
}