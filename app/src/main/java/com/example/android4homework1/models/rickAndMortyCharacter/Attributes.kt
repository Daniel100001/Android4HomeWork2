package com.example.android4homework1.models.rickAndMortyCharacter

import com.google.gson.annotations.SerializedName

data class Attributes(

    @SerializedName("titles")
    val titles: Titles,

    @SerializedName("posterImage")
    val posterImage: PosterImage,

    @SerializedName("description")
    val description: String
)