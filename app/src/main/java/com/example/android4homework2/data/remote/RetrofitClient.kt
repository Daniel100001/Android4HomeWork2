package com.example.android4homework2.data.remote

import com.example.android4homework2.data.remote.apisevices.AnimeApiService
import com.example.android4homework2.data.remote.apisevices.MangaApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://kitsu.io/api/edge/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideAnimeApiService(): AnimeApiService {
        return retrofitClient.create(AnimeApiService::class.java)
    }

    fun provideMangaApiService(): MangaApiService {
        return retrofitClient.create(MangaApiService::class.java)
    }
}