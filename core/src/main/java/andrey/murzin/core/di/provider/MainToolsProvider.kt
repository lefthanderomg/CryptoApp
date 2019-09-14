package andrey.murzin.core.di.provider

import ru.terrakok.cicerone.Router

interface MainToolsProvider : AppProvider {
    fun provide(): Router
}