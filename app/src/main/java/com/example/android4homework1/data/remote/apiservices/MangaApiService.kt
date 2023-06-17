package com.example.android4homework1.data.remote.apiservices

import com.example.android4homework1.models.AnimeResponse
import com.example.android4homework1.models.rickAndMortyCharacter.MangaModel
import retrofit2.http.GET
import retrofit2.http.Query

interface MangaApiService {

    @GET("manga")
    suspend fun fetchCharacters(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int
    ) : AnimeResponse<MangaModel>

}