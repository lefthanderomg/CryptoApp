package andrey.murzin.network.interceptor


import andrey.murzin.core.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AppInterceptor : Interceptor {

    companion object {
        private const val API_KEY_NAME = "X-CMC_PRO_API_KEY"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.newBuilder().addHeader(
            API_KEY_NAME,
            BuildConfig.SANDBOX_API_KEY
        ).build()

        return chain.proceed(url)
    }
}