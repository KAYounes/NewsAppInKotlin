package com.example.newsappinkotlin.models

import com.google.gson.annotations.SerializedName

data class HeadLineModel (
    @SerializedName("name") var headLineSource: Source,
    @SerializedName("title") var headLineTitle: String,
    @SerializedName("urlToImage") var headLineThumbNail: String,
    @SerializedName("publishedAt") var headLinePublish: String
)


class Source(
    val id: String?,
    val name: String
)