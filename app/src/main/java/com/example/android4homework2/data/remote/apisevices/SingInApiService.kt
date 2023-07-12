package com.example.android4homework2.data.remote.apisevices

import com.example.android4homework2.data.models.SingInModel
import com.example.android4homework2.data.models.SingInModel2
import retrofit2.http.Body
import retrofit2.http.POST

interface SingInApiService {

    @POST("oauth/token")
   suspend fun singIn(
        @Body singInModel2: SingInModel2
    ): SingInModel
}