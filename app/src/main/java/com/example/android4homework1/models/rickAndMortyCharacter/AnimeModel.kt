package com.example.android4homework1.models.rickAndMortyCharacter

import com.google.gson.annotations.SerializedName

data class AnimeModel(

    @SerializedName("id")
    val id: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("attributes")
    val attributes: Attributes
)





