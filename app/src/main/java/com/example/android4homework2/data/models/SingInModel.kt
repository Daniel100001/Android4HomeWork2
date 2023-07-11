package com.example.android4homework2.data.models

import com.google.gson.annotations.SerializedName

data class SingInModel(

    @SerializedName("access_token")
    val access_token : String,
    @SerializedName("created_at")
    val created_at: Int,
    @SerializedName("expires_in")
    val expires_in: Int,
    @SerializedName("refresh_token")
    val refresh_token: String,

    @SerializedName("token_type")
    val token_type: String

)