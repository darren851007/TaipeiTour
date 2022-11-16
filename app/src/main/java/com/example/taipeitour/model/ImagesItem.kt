package com.example.taipeitour.model

import com.google.gson.annotations.SerializedName

data class ImagesItem(@SerializedName("ext")
                      val ext: String = "",
                      @SerializedName("src")
                      val src: String = "",
                      @SerializedName("subject")
                      val subject: String = "")