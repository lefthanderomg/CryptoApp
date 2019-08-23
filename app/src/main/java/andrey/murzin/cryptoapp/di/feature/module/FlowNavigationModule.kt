package andrey.murzin.cryptoapp.di.feature.module

import andrey.murzin.cryptoapp.di.scope.FeatureScope
import andrey.murzin.cryptoapp.tools.router.FlowRouter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

@Module
class FlowNavigationModule {
    @Provides
    @FeatureScope
    fun provideCicerone(router: Router): Cicerone<FlowRouter> = Cicerone.create(FlowRouter(router))

    @Provides
    @FeatureScope
    fun provideRouter(cicerone: Cicerone<FlowRouter>): FlowRouter = cicerone.router

    @Provides
    @FeatureScope
    fun provideNavigationHolder(cicerone: Cicerone<FlowRouter>): NavigatorHolder =
        cicerone.navigatorHolder
}