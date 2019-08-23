package andrey.murzin.cryptoapp.presetation.feature.main.view

import andrey.murzin.cryptoapp.R
import andrey.murzin.cryptoapp.app.App
import andrey.murzin.cryptoapp.di.provider.AppProvider
import andrey.murzin.cryptoapp.presetation.feature.main.di.component.MainComponent
import andrey.murzin.cryptoapp.presetation.feature.main.di.provider.MainToolsProvider
import andrey.murzin.cryptoapp.presetation.provider.ActivityToolsHolder
import andrey.murzin.cryptoapp.tools.logger.Logger
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ActivityToolsHolder {

    @Inject
    lateinit var logger: Logger

    private val mainComponent: MainComponent by lazy {
        val appComponent: AppProvider = (applicationContext as App).getAppComponent()
        MainComponent.Initializer.init(appComponent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun getActivityToolsProvider(): MainToolsProvider = mainComponent
}
