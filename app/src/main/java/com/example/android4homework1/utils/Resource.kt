package com.example.android4homework1.utils

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
){

    class Loading<T>(data: T?= null): Resource<T> (data = data)

    class Success<T> (data: T): Resource<T> (data = data)

    class Error<T> ( message: String?, data: T?): Resource<T> (data= data, message=message)
}