package com.example.taipeitour.network

import com.example.taipeitour.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private val BASE_URL = Config.BASE_URL
    private val okHttpClient = createOkHttpClient()

    private fun createOkHttpClient(): OkHttpClient {
        val logging: HttpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(
                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            )
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

    val instance: ApiInterface by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        retrofit.create(ApiInterface::class.java)
    }
}

