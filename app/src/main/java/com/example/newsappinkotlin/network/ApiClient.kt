package com.example.newsappinkotlin.network

import com.example.newsappinkotlin.models.HeadLineModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val baseURL = "https://newsapi.org/"
    val endPoint: ApiEndPoints

    init {
        val retro = Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build()

        endPoint = retro.create(
            ApiEndPoints::class.java)
    }

    fun requestTopHeadLines(onResponse :(headlines: List<HeadLineModel>) -> Unit, onFail: () -> Unit){
        endPoint.getTopHeadLines().enqueue(object : Callback<TopHeadLinesResponse>{
            override fun onFailure(call: Call<TopHeadLinesResponse>, t: Throwable) {
                onFail.invoke()
            }

            override fun onResponse(
                call: Call<TopHeadLinesResponse>,
                response: Response<TopHeadLinesResponse>
            ) {
                onResponse.invoke(response.body()!!.headlines)
            }

        })
    }

}