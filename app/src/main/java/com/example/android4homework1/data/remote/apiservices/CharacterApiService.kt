package com.example.android4homework1.data.remote.apiservices

import com.example.android4homework1.models.RickAndMortyResponse
import com.example.android4homework1.models.rickAndMortyCharacter.AnimeModel
import retrofit2.http.GET
import retrofit2.http.POST

interface CharacterApiService {

    @GET("anime")
    suspend fun fetchCharacters(
    ) : RickAndMortyResponse<AnimeModel>
}