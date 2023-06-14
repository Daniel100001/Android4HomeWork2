package com.example.android4homework1.data.remote.apiservices

import com.example.android4homework1.models.AnimeResponse
import com.example.android4homework1.models.rickAndMortyCharacter.AnimeDetail
import com.example.android4homework1.models.rickAndMortyCharacter.AnimeModel
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApiService {

    @GET("anime")
    suspend fun fetchCharacters(
    ) : AnimeResponse<AnimeModel>

    @GET("anime/{id}")
    suspend fun fetchSingleAnime(
        @Path("id") id: String
    ): AnimeDetail
}