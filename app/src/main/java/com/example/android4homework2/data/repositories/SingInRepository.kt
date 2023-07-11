package com.example.android4homework2.data.repositories

import com.example.android4homework2.base.BaseRepository
import com.example.android4homework2.data.models.SingInModel2
import com.example.android4homework2.data.remote.apisevices.SingInApiService
import javax.inject.Inject

class SingInRepository @Inject constructor(private val service: SingInApiService) : BaseRepository() {

    fun singIn(singInModel2: SingInModel2) = doRequest {
        service.singIn(singInModel2)
    }
}