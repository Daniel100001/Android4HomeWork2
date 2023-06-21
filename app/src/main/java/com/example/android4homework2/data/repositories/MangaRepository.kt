package com.example.android4homework2.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.android4homework2.base.BaseRepository
import com.example.android4homework2.data.remote.apisevices.MangaApiService
import com.example.android4homework2.data.repositories.pagingsource.MangaPagingSource
import javax.inject.Inject

class MangaRepository @Inject constructor(private val service: MangaApiService) : BaseRepository() {

    fun fetchManga() = Pager(
        PagingConfig(
            pageSize = 10,
            initialLoadSize = 20
        )
    ) {
        MangaPagingSource(service)
    }.liveData


    fun fetchMangaById(id: Int) = doRequest {
        service.fetchMangaById(id)
    }
}