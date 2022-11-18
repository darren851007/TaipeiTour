package com.example.taipeitour.network

object Config {
    const val BASE_URL: String = "https://www.travel.taipei/open-api/"
    val LANGUAGE: Map<String, String> = mapOf(
        Pair("ZH_TW", "zh-tw"),
        Pair("ZH_CN", "zh-cn"),
        Pair("EN", "en"),
        Pair("JP", "jp"),
        Pair("KO", "ko"),
        Pair("ES", "es"),
        Pair("ID", "id"),
        Pair("TH", "th"),
        Pair("VI", "vi")
    )


}