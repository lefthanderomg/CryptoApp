package andrey.murzin.screen_main.di.module

import andrey.murzin.core.utils.Launcher
import andrey.murzin.screen_main.tools.launcher.AppLauncher
import dagger.Binds
import dagger.Module

@Module
abstract class MainFeatureModule {
    @Binds
    abstract fun provideLauncher(appLauncher: AppLauncher): Launcher
}