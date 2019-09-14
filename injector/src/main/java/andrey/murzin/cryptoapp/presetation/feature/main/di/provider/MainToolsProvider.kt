package andrey.murzin.cryptoapp.presetation.feature.main.di.provider

import andrey.murzin.core.di.provider.AppProvider
import ru.terrakok.cicerone.Router

interface MainToolsProvider : AppProvider {
    fun provide(): Router
}