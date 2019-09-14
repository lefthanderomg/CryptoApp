package andrey.murzin.cryptoapp.presetation.feature.main.view

import andrey.murzin.cryptoapp.R
import andrey.murzin.core.App
import andrey.murzin.cryptoapp.presetation.feature.main.di.component.MainComponent
import andrey.murzin.cryptoapp.presetation.feature.main.di.provider.MainToolsProvider
import andrey.murzin.cryptoapp.presetation.base.ActivityToolsHolder
import andrey.murzin.core.utils.Launcher
import android.os.Bundle
import android.view.ActionMode
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
        object : SupportAppNavigator(this@MainActivity, supportFragmentManager, R.id.container) {

        }
    }

    private val mainComponent: MainComponent by lazy {
        MainComponent.Initializer.componentInstance.init(
            (applicationContext as App).getAppComponent()
        )
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
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
