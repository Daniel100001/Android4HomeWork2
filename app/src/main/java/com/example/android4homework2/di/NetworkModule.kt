package com.example.android4homework2.di

import com.example.android4homework2.data.remote.RetrofitClient
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
    fun provideMangaApiService(retrofitClient: RetrofitClient) =
        RetrofitClient().provideMangaApiService()

    @Singleton
    @Provides
    fun provideAnimeApiService(retrofitClient: RetrofitClient) =
        RetrofitClient().provideAnimeApiService()

}