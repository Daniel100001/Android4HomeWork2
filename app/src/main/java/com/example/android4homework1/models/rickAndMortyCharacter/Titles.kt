package com.example.android4homework1.models.rickAndMortyCharacter

import com.google.gson.annotations.SerializedName

data class Titles(

    @SerializedName("ja_jp")
    val nameInJapanese: String,

    @SerializedName("en_jp")
    val nameInEnglish: String
)