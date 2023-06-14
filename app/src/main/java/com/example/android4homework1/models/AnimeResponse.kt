package com.example.android4homework1.models

import com.google.gson.annotations.SerializedName

data class AnimeResponse<T>(

    @SerializedName("data")
    val data: List<T>,

    @SerializedName("links")
    val links: Links
)
