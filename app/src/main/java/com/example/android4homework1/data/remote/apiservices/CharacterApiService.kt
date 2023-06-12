package com.example.android4homework1.data.remote.apiservices

import com.example.android4homework1.models.RickAndMortyResponse
import com.example.android4homework1.models.rickAndMortyCharacter.CharacterModel
import retrofit2.http.GET

interface CharacterApiService {

    @GET("character")
    suspend fun fetchCharacters() : RickAndMortyResponse<CharacterModel>
}