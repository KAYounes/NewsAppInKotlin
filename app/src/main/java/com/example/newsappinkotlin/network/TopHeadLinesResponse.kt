package com.example.newsappinkotlin.network

import com.example.newsappinkotlin.models.HeadLineModel
import com.google.gson.annotations.SerializedName

data class TopHeadLinesResponse(
    @SerializedName("articles") val headlines: List<HeadLineModel>//,
//    @SerializedName("articles") val headlines: List<HeadLineModel>,
)
