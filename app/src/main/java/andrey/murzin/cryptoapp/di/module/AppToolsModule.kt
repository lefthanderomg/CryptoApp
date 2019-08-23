package andrey.murzin.cryptoapp.di.module

import andrey.murzin.cryptoapp.tools.logger.AppLogger
import andrey.murzin.cryptoapp.tools.logger.Logger
import dagger.Binds
import dagger.Module

@Module
abstract class AppToolsModule {
    @Binds
    abstract fun providerLogger(implementation: AppLogger): Logger
}