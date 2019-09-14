package andrey.murzin.cryptoapp.presetation.feature.main.di.module

import andrey.murzin.cryptoapp.tools.launcher.AppLauncher
import andrey.murzin.core.utils.Launcher
import dagger.Binds
import dagger.Module

@Module
abstract class MainFeatureModule {
    @Binds
    abstract fun provideLauncher(appLauncher: AppLauncher): Launcher
}