package andrey.murzin.cryptoapp.app

import andrey.murzin.cryptoapp.di.provider.AppProvider

interface App {
    fun getAppComponent(): AppProvider
}