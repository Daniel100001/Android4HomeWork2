package com.example.android4homework1.di

import com.example.android4homework1.data.remote.RetrofitClient
import com.example.android4homework1.data.remote.apiservices.MangaApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitClient() = RetrofitClient()


    @Singleton
    @Provides
    fun provideAnimeApiService(retrofitClient: RetrofitClient): MangaApiService =
        retrofitClient.provideAnimeApiService()
}