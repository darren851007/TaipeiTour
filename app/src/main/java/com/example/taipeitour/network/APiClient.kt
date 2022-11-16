package com.example.taipeitour.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APiClient {
    companion object {
        private const val BASE_URL: String = "https://www.travel.taipei/open-api/"
        private var retrofit: Retrofit? = null

        fun getClient(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
    }
}