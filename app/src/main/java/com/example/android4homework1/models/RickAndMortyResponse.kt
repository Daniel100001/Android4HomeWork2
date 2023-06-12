package com.example.android4homework1.models

import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse<T>(

    @SerializedName("info")
    val info: Info,

    @SerializedName("results")
    val results: List<T>,
)
