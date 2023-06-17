package com.example.android4homework1.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.android4homework1.data.remote.apiservices.MangaApiService
import com.example.android4homework1.data.repositories.pagingsources.MangaPagingSource
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val service: MangaApiService
) {

    fun fetchCharacters() = Pager(
        PagingConfig(10, initialLoadSize = 10, enablePlaceholders = true)
    ){
        MangaPagingSource(service)
    }.liveData
}