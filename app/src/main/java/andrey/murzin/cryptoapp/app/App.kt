package andrey.murzin.cryptoapp.app

import andrey.murzin.cryptoapp.di.app.provider.AppProvider

interface App {
    fun getAppComponent(): AppProvider
}