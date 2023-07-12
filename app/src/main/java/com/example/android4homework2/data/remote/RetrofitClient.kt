package com.example.android4homework2.data.remote

import com.example.android4homework2.data.remote.apisevices.AnimeApiService
import com.example.android4homework2.data.remote.apisevices.MangaApiService
import com.example.android4homework2.data.remote.apisevices.SingInApiService
import com.example.android4homework2.data.remote.interceptors.AccessInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okkHttClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(provideLoggingInterceptor())
        .addInterceptor(AccessInterceptor())
        .callTimeout(30,TimeUnit.SECONDS)
        .connectTimeout(30,TimeUnit.SECONDS)
        .readTimeout(30,TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://kitsu.io/api/")
        .client(okkHttClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun provideAnimeApiService(): AnimeApiService {
        return retrofitClient.create(AnimeApiService::class.java)
    }

    fun provideMangaApiService(): MangaApiService {
        return retrofitClient.create(MangaApiService::class.java)
    }

    fun provideSingInApiService(): SingInApiService{
        return retrofitClient.create(SingInApiService::class.java)
    }
    fun provideLoggingInterceptor() = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
}