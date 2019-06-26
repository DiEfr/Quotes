package com.example.quotes

import com.example.quotes.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService {

    private val okHttpClient: OkHttpClient
    val service: Service

    private object Holder { val INSTANCE = NetworkService() }

    companion object {
        val instance: NetworkService by lazy { Holder.INSTANCE }
    }

    init {
        okHttpClient = getHttpClient()
        service = makeService(okHttpClient)
    }

    private fun getHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpClientBuilder.addInterceptor(interceptor)
        }
        return okHttpClientBuilder.build()
    }

    private fun makeService(okHttpClient: OkHttpClient): Service{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(Service::class.java)
    }
}