package com.example.android4homework2.data.remote.interceptors

import okhttp3.Interceptor
import okhttp3.Response

const val accessToken: String = "access_token"

class AccessInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url =
            request.url.newBuilder()
                .addQueryParameter(
                    "Authorization:",
                    "Bearer $accessToken"
                )
                .build()
        request = request.newBuilder().url(url).build()

        return chain.proceed(request)
    }
}

//"900Njke2Yw-qsWzrP6fkTMAMyynVHPSCx86DxbJMkcM"
//"qwXISBggyKfJzDvjvZFpfE2SV7brjpyWWxYbuteaYlQ"