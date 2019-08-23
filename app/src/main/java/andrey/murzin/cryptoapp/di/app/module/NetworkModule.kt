package andrey.murzin.cryptoapp.di.app.module

import andrey.murzin.cryptoapp.BuildConfig
import android.util.Log
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val READ_TIMEOUT = 30L
        private const val WRITE_TIMEOUT = 30L
        private const val CONNECT_TIMEOUT = 30L
        private const val REQUEST_TAG = "Request"
        private const val RESPONSE_TAG = "Response"
    }

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor(): LoggingInterceptor =
        LoggingInterceptor
            .Builder()
            .loggable(BuildConfig.DEBUG)
            .setLevel(Level.BASIC)
            .log(Log.INFO)
            .request(REQUEST_TAG)
            .response(RESPONSE_TAG)
            .build()

    @Singleton
    @Provides
    fun provideOkHttpClient(logging: LoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().apply {
            addInterceptor(logging)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        }.build()
}