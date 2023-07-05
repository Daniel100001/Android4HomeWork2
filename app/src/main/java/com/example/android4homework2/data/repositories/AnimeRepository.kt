package com.example.android4homework2.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.android4homework2.base.BaseRepository
import com.example.android4homework2.data.remote.apisevices.AnimeApiService
import com.example.android4homework2.data.repositories.pagingsource.AnimePagingSource
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val service: AnimeApiService) : BaseRepository() {

    fun fetchAnime() = Pager(
        PagingConfig(
            pageSize = 10,
            initialLoadSize = 10
        )
    ) {
        AnimePagingSource(service)
    }.liveData

    fun fetchSingleAnime(id: Int) = doRequest {
        service.fetchSingleAnime(id)
    }
}