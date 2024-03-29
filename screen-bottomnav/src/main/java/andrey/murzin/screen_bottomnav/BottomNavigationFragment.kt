package andrey.murzin.screen_bottomnav

import andrey.murzin.core_ui.base.BaseFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_bottom_navigation.*

class BottomNavigationFragment : BaseFragment() {

    private val currentTabFragment: BaseFragment?
        get() = childFragmentManager.fragments.firstOrNull { !it.isHidden } as? BaseFragment

    override fun getLayoutResId(): Int = R.layout.fragment_bottom_navigation

    override fun onBackPressed() {
        currentTabFragment?.onBackPressed()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (childFragmentManager.fragments.isEmpty()) {
            with(bottomNav) {
                if (currentTabFragment == null) selectTab(selectedItemId)
                setOnNavigationItemSelectedListener {
                    selectTab(it.itemId)
                    true
                }
            }
        }
    }

    private fun selectTab(@IdRes idTab: Int) {
        val currentFragment = currentTabFragment
        val screens = when (idTab) {
            R.id.tabExchange -> Screens.ExchangeTab
            R.id.tabCurrency -> Screens.CurrencyTab
            R.id.tabMetrics ->  Screens.ExchangeTab
            R.id.tabPartner -> Screens.ExchangeTab
            R.id.tabTool -> Screens.ExchangeTab
            else -> throw IllegalArgumentException("Screen not found")
        }
        val newFragment = childFragmentManager.findFragmentByTag(screens.screenKey)
        if (currentFragment != null && newFragment != null && currentFragment == newFragment) return

        childFragmentManager.beginTransaction().apply {
            if (newFragment == null) {
                add(R.id.bottomNavContainer, screens.fragment, screens.screenKey)
            }
            currentFragment?.let { hide(it) }
            newFragment?.let { show(it) }
        }.commitNow()
    }
}