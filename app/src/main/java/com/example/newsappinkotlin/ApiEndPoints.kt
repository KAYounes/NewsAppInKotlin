package com.example.newsappinkotlin

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndPoints {
    @GET("v2/top-headlines")

    fun getTopHeadLines(
        @Query("country") country: String,
        @Query("apiKey") key: String = "cac7619eebd84f24a1e30ace5c13708b"
    ): Call<TopHeadLinesResponse>


}