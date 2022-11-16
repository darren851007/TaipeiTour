package com.example.taipeitour.model

import com.google.gson.annotations.SerializedName

data class CategoryItem(@SerializedName("name")
                        val name: String = "",
                        @SerializedName("id")
                        val id: Int = 0)