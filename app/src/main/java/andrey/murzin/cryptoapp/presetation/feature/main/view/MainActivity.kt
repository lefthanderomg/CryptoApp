package andrey.murzin.cryptoapp.presetation.feature.main.view

import andrey.murzin.cryptoapp.R
import andrey.murzin.cryptoapp.app.App
import andrey.murzin.cryptoapp.presetation.feature.main.di.component.MainComponent
import andrey.murzin.cryptoapp.presetation.feature.main.di.provider.MainToolsProvider
import andrey.murzin.cryptoapp.presetation.provider.ActivityToolsHolder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ActivityToolsHolder {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    @Inject
    lateinit var router: Router

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
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing) MainComponent.Initializer.componentInstance.clearInstance()
    }

    override fun getActivityToolsProvider(): MainToolsProvider = mainComponent
}
