package com.example.newsappinkotlin.network

import com.google.gson.annotations.SerializedName

data class TopHeadLinesResponse(
    @SerializedName("source") val headLineSource: Source,
    @SerializedName("title") val headLineTitle: String,
    @SerializedName("urlToImage") val headLineThumbNail: String,
    @SerializedName("publishedAt") val published: String
)

class Source(
    val id: String?,
    val name: String
)