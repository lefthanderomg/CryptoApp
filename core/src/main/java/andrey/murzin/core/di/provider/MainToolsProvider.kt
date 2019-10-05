package andrey.murzin.core.di.provider

import andrey.murzin.core.routing.StartPurchaseFlow
import ru.terrakok.cicerone.Router

interface MainToolsProvider : AppProvider {
    fun provide(): Router
    fun provideStartPurcheseFlow(): StartPurchaseFlow
}