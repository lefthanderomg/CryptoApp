package andrey.murzin.screen_main.di.module

import andrey.murzin.core.routing.StartPurchaseFlow
import andrey.murzin.core.utils.Launcher
import andrey.murzin.screen_main.routing.StartPurchaseFlowImpl
import andrey.murzin.screen_main.tools.launcher.AppLauncher
import dagger.Binds
import dagger.Module

@Module
abstract class MainFeatureModule {
    @Binds
    abstract fun provideLauncher(appLauncher: AppLauncher): Launcher

    @Binds
    abstract fun providePurchase(startPurchaseFlowImpl: StartPurchaseFlowImpl): StartPurchaseFlow
}