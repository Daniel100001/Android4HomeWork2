package com.example.android4homework2.data.models

import com.google.gson.annotations.SerializedName

data class Attributes(

    @SerializedName("synopsis")
    val detail: String,

    @SerializedName("titles")
    val title: Titles,

    @SerializedName("posterImage")
    val posterImage: PosterImage

)
