package andrey.murzin.core

import andrey.murzin.core.di.provider.AppProvider
import android.content.Context

interface App {
    fun getApplicationContext(): Context
    fun getAppComponent(): AppProvider
}