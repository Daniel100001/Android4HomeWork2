package com.example.android4homework2.data.models

import com.google.gson.annotations.SerializedName

data class AnimeDetail(

    @SerializedName("data")
    val animeModel: AnimeModel
)
