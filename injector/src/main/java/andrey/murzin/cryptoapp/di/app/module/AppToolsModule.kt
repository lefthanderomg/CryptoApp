package andrey.murzin.cryptoapp.di.app.module

import andrey.murzin.cryptoapp.tools.logger.AppLogger
import andrey.murzin.cryptoapp.tools.logger.Logger
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AppToolsModule {

    @Binds
    abstract fun providerLogger(implementation: AppLogger): Logger
}