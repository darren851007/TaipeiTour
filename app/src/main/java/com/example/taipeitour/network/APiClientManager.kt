package com.example.taipeitour.network

import com.example.taipeitour.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class APiClientManager {
    private val retrofit: Retrofit
    private val okHttpClient = createOkHttpClient()

    init {
                retrofit = Retrofit.Builder()
                    .baseUrl(Config.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
    }

    private fun createOkHttpClient(): OkHttpClient {
        val logging: HttpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(if(BuildConfig.DEBUG){HttpLoggingInterceptor.Level.BODY}else
            {HttpLoggingInterceptor.Level.NONE})
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(Interceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("accept", "application/json")
                    .build()
                chain.proceed(newRequest)
            })
            .connectTimeout(60L, TimeUnit.SECONDS)
            .build()
    }

    companion object {
        private val manager = APiClientManager()
        val client: Retrofit
            get() = manager.retrofit
    }
}
