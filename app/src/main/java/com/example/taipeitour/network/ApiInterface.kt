package com.example.taipeitour.network

import com.example.taipeitour.model.DataItem
import com.example.taipeitour.model.TaipeiTourModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("{lang}/Attractions/All")
    fun getAttractions(@Path(value = "lang",) lang: String, @Query(value = "page") page: Int): Call<TaipeiTourModel>
}