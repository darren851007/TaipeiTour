package com.example.taipeitour.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DataItem(@SerializedName("name_zh")
                    val nameZh: Any? = null,
                    @SerializedName("distric")
                    val distric: String = "",
                    @SerializedName("nlat")
                    val nlat: Double = 0.0,
                    @SerializedName("open_time")
                    val openTime: String = "",
                    @SerializedName("open_status")
                    val openStatus: Int = 0,
                    @SerializedName("remind")
                    val remind: String = "",
                    @SerializedName("modified")
                    val modified: String = "",
                    @SerializedName("tel")
                    val tel: String = "",
                    @SerializedName("id")
                    val id: Int = 0,
                    @SerializedName("fax")
                    val fax: String = "",
                    @SerializedName("introduction")
                    val introduction: String = "",
                    @SerializedName("email")
                    val email: String = "",
                    @SerializedName("images")
                    val images: List<ImagesItem>?,
                    @SerializedName("address")
                    val address: String = "",
                    @SerializedName("months")
                    val months: String = "",
                    @SerializedName("elong")
                    val elong: Double = 0.0,
                    @SerializedName("ticket")
                    val ticket: String = "",
                    @SerializedName("facebook")
                    val facebook: String = "",
                    @SerializedName("url")
                    val url: String = "",
                    @SerializedName("target")
                    val target: List<TargetItem>?,
                    @SerializedName("zipcode")
                    val zipcode: String = "",
                    @SerializedName("service")
                    val service: List<ServiceItem>?,
                    @SerializedName("name")
                    val name: String = "",
                    @SerializedName("staytime")
                    val staytime: String = "",
                    @SerializedName("official_site")
                    val officialSite: String = "",
                    @SerializedName("category")
                    val category: List<CategoryItem>?) : Serializable