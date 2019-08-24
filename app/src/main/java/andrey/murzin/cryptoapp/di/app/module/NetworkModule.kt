package andrey.murzin.cryptoapp.di.app.module

import andrey.murzin.cryptoapp.BuildConfig
import andrey.murzin.cryptoapp.data.interceptor.AppInterceptor
import andrey.murzin.cryptoapp.data.network.CoinMarketApi
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
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
    fun provideOkHttpClient(logging: LoggingInterceptor,
                            appInterceptor: AppInterceptor): OkHttpClient =
        OkHttpClient.Builder().apply {
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            addInterceptor(appInterceptor)
            addInterceptor(logging)
        }.build()

    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().serializeNulls().create()

    @Singleton
    @Provides
    fun provideAppInterceptor(): AppInterceptor = AppInterceptor()

    @Singleton
    @Provides
    fun provideCoinMarketApi(
        gson: Gson,
        client: OkHttpClient
    ): CoinMarketApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.SANDBOX_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(CoinMarketApi::class.java)
    }
}