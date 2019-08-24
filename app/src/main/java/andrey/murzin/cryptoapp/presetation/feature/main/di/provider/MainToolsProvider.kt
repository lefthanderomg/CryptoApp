package andrey.murzin.cryptoapp.presetation.feature.main.di.provider

import andrey.murzin.cryptoapp.tools.logger.Logger
import ru.terrakok.cicerone.Router

interface MainToolsProvider {
    fun provideRouter() : Router
    fun provideLogger() : Logger
}