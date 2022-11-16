package com.example.taipeitour.network

import com.example.taipeitour.model.TaipeiTourListModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("zh-tw/Attractions/All")
    fun getAttractions(): Call<TaipeiTourListModel>
}