package com.example.android4homework1.models.rickAndMortyCharacter

import com.google.gson.annotations.SerializedName

data class PosterImage(

    @SerializedName("original")
    val original: String
)