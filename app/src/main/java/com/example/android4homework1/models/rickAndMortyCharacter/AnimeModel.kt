package com.example.android4homework1.models.rickAndMortyCharacter

import com.google.gson.annotations.SerializedName

data class AnimeModel(

    @SerializedName("id")
    val id: String = "",

    @SerializedName("type")
    val type: String = "",

    @SerializedName("attributes")
    val attributes: Attributes

)

data class Attributes(

    @SerializedName("titles")
    val titles: Titles,

    @SerializedName("posterImage")
    val posterImage: PosterImage,

    @SerializedName("description")
    val description: String = ""
)

data class Titles(
    @SerializedName("ja_jp")
    val nameInJapanese: String = ""
)

data class PosterImage(
    @SerializedName("original")
    val original: String = ""
)

