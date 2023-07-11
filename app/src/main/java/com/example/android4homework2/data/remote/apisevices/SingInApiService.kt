package com.example.android4homework2.data.remote.apisevices

import com.example.android4homework2.data.models.SingInModel
import com.example.android4homework2.data.models.SingInModel2
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.Url

interface SingInApiService {

    @POST("oauth/token")
   suspend fun singIn(
        @Body singInModel2: SingInModel2
    ): Response<SingInModel>
    // @Field("grand_type") @Field("username") @Field("password")
}