package andrey.murzin.cryptoapp.presetation.feature.bottomnavigation

import andrey.murzin.cryptoapp.R
import andrey.murzin.cryptoapp.Screens
import andrey.murzin.cryptoapp.presetation.base.ActivityToolsHolder
import andrey.murzin.cryptoapp.presetation.base.BaseFragment
import andrey.murzin.cryptoapp.presetation.base.FragmentBottomNavigationToolsHolder
import andrey.murzin.cryptoapp.presetation.feature.bottomnavigation.di.component.BottomNavigationComponent
import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import kotlinx.android.synthetic.main.fragment_bottom_navigation.*

class BottomNavigationFragment : BaseFragment(), FragmentBottomNavigationToolsHolder {

    private val bottomNavigationComponent by lazy {
        val activityToolsHolder = activity as ActivityToolsHolder
        BottomNavigationComponent.Initializer.componentInstance
            .init(activityToolsHolder.getActivityToolsProvider())
    }

    private val currentTabFragment: BaseFragment?
        get() = childFragmentManager.fragments.firstOrNull { !it.isHidden } as? BaseFragment

    override fun getLayoutResId(): Int = R.layout.fragment_bottom_navigation

    override fun inject() {
        bottomNavigationComponent.inject(this)
    }

    override fun clearScope() {
        BottomNavigationComponent.Initializer.componentInstance.clearInstance()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(bottomNav) {
            if (currentTabFragment == null) selectTab(selectedItemId)
            setOnNavigationItemSelectedListener {
                selectTab(it.itemId)
                true
            }
        }
    }

    override fun getBottomNavigationToolsProvider() = bottomNavigationComponent

    private fun selectTab(@IdRes idTab: Int) {
        val currentFragment = currentTabFragment
        val screens = when (idTab) {
            R.id.tabExchange -> Screens.ExchangeTab
            R.id.tabCurrency -> Screens.CurrencyTab
            R.id.tabMetrics -> Screens.MetricTab
            R.id.tabPartner -> Screens.PartnerTab
            R.id.tabTool -> Screens.ToolsTab
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