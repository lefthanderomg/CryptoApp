package andrey.murzin.cryptoapp.app

import andrey.murzin.cryptoapp.BuildConfig
import andrey.murzin.cryptoapp.di.app.component.AppComponent
import andrey.murzin.cryptoapp.di.app.provider.AppProvider
import android.app.Application
import timber.log.Timber

class AppCrypto : Application(), App {

    private val appComponent: AppComponent by lazy {
        AppComponent.Initializer.init(this@AppCrypto)
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
        if (BuildConfig.DEBUG) {
            performDebugTools()
        }
    }

    override fun getAppComponent(): AppProvider = appComponent

    private fun performDebugTools() {
        Timber.plant(Timber.DebugTree())
    }
}