package andrey.murzin.cryptoapp.di.feature.module

import andrey.murzin.cryptoapp.di.scope.FlowScope
import andrey.murzin.cryptoapp.tools.router.FlowRouter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Named

@Module
class FlowNavigationModule {

    companion object {
        const val FlOW = "FLOW"
    }

    @Provides
    @FlowScope
    fun provideCicerone(router: Router): Cicerone<FlowRouter> = Cicerone.create(FlowRouter(router))

    @Provides
    @FlowScope
    fun provideRouter(cicerone: Cicerone<FlowRouter>): FlowRouter = cicerone.router

    @Provides
    @FlowScope
    @Named(FlOW)
    fun provideNavigationHolder(cicerone: Cicerone<FlowRouter>): NavigatorHolder =
        cicerone.navigatorHolder
}