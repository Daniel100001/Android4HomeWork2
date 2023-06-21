package com.example.android4homework2.data.models

import com.google.gson.annotations.SerializedName

data class AnimeModel(

    @SerializedName("id")
    val id: String,

    @SerializedName("attributes")
    val attributes: Attributes
)