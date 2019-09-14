package andrey.murzin.cryptoapp.app

import andrey.murzin.core.App
import andrey.murzin.cryptoapp.BuildConfig
import andrey.murzin.cryptoapp.di.app.component.AppComponent
import andrey.murzin.core.di.provider.AppProvider
import android.app.Application
import android.content.Context
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

    override fun getApplicationContext(): Context = this

    override fun getAppComponent(): AppProvider = appComponent

    private fun performDebugTools() {
        Timber.plant(Timber.DebugTree())
    }
}