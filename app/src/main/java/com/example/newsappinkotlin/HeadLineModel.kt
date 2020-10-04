package com.example.newsappinkotlin

import com.google.gson.annotations.SerializedName

data class HeadLineModel (
    @SerializedName("name")val headLineSource: String,
    @SerializedName("title")val headLineTitle: String,
    @SerializedName("urlToImage")val headLineThumbNail: String,
    @SerializedName("publishedAt")val headLinePublish: String
)