package com.example.taipeitour.model

import com.google.gson.annotations.SerializedName

data class TaipeiTourModel(@SerializedName("total")
                           val total: Int = 0,
                           @SerializedName("data")
                           val data: List<DataItem>?)