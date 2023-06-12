package com.example.android4homework1.data.repositories

import androidx.lifecycle.liveData
import com.example.android4homework1.data.remote.apiservices.CharacterApiService
import com.example.android4homework1.utils.Resource
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val service: CharacterApiService
) {

    fun fetchCharacters() = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(service.fetchCharacters()))
        }catch (exception: Exception){
            emit(Resource.Error(exception.localizedMessage ?: "Error",null))
        }
    }
}