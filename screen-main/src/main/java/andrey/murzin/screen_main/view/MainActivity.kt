package andrey.murzin.screen_main.view

import andrey.murzin.core.App
import andrey.murzin.core.di.holder.ActivityToolsHolder
import andrey.murzin.core.di.provider.MainToolsProvider
import andrey.murzin.core.utils.Launcher
import andrey.murzin.core_ui.base.BaseFragment
import andrey.murzin.screen_main.R
import andrey.murzin.screen_main.di.component.MainComponent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity(),
    ActivityToolsHolder {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    @Inject
    lateinit var launcher: Launcher

    private val navigator: Navigator by lazy {
        object : SupportAppNavigator(
            this@MainActivity,
            supportFragmentManager,
            R.id.container
        ) {}
    }

    private val mainComponent: MainComponent by lazy {
        MainComponent.Initializer.componentInstance.init(
            (applicationContext as App).getAppComponent()
        )
    }

    private val currentFragment: BaseFragment?
        get() = supportFragmentManager.findFragmentById(R.id.container) as? BaseFragment

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            launcher.coldStart()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing) MainComponent.Initializer.componentInstance.clearInstance()
    }

    override fun getActivityToolsProvider(): MainToolsProvider = mainComponent
}
