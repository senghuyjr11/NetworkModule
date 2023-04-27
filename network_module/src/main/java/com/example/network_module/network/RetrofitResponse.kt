package com.example.network_module.network

sealed class RetrofitResponse<out T> {

    data class Success<T>(val body: T) : RetrofitResponse<T>()

    data class Exception<T>(val throwable: Throwable) : RetrofitResponse<T>()

    data class Error<T>(val code: String? = null, val message : String? = null) : RetrofitResponse<T>()
}