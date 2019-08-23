package andrey.murzin.cryptoapp.presetation.feature.main.di.provider

import ru.terrakok.cicerone.Router

interface MainToolsProvider {
    fun provideRouter() : Router
}