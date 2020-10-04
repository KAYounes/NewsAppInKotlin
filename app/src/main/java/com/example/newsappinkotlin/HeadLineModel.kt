package com.example.newsappinkotlin

import com.google.gson.annotations.SerializedName

data class HeadLineModel (
    @SerializedName("name") var headLineSource: String,
    @SerializedName("title") var headLineTitle: String,
    @SerializedName("urlToImage") var headLineThumbNail: String,
    @SerializedName("publishedAt") var headLinePublish: String
)