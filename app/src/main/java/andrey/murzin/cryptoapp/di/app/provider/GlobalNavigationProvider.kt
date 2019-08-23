package andrey.murzin.cryptoapp.di.app.provider

import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

interface GlobalNavigationProvider {
    fun provideNavigation(): NavigatorHolder
    fun provideRouter(): Router
}