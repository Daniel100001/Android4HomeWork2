package com.example.android4homework2.data.models

import com.google.gson.annotations.SerializedName

data class SingInModel2(
    @SerializedName("grant_type")
    val grant_type: String,
    @SerializedName("username")
    val email: String,
    @SerializedName("password")
    val password: String,
)