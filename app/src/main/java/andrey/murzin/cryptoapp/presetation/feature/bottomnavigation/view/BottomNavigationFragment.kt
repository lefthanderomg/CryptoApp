package andrey.murzin.cryptoapp.presetation.feature.bottomnavigation.view

import andrey.murzin.cryptoapp.R
import andrey.murzin.cryptoapp.presetation.base.BaseFragment
import andrey.murzin.cryptoapp.presetation.feature.bottomnavigation.di.component.BottomNavigationComponent
import andrey.murzin.cryptoapp.presetation.provider.ActivityToolsHolder
import android.os.Bundle
import android.view.View

class BottomNavigationFragment : BaseFragment() {

    override fun getLayoutResId(): Int = R.layout.fragment_bottom_navigation

    override fun inject() {
        val activityToolsHolder = activity as ActivityToolsHolder
        val component = BottomNavigationComponent.Initializer.componentInstance
            .init(activityToolsHolder.getActivityToolsProvider())
        component.inject(this)
    }

    override fun clearScope() {
        BottomNavigationComponent.Initializer.componentInstance.clearInstance()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}