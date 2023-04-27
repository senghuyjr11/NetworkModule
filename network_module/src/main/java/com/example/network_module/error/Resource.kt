package com.example.network_module.error

sealed class Resource<out T>(
    val status: Status,
    val data: T?,
    val code: String?,
    val message: String?
) {

   data class Loading<out T>(
      private val resource: T? = null
   ) : Resource<T>(Status.LOADING, resource, null, null)

   data class Success<out T>(
      private val resource: T?,
   ) : Resource<T>(Status.SUCCESS, resource, null, null)

   data class Error<out T>(
      private val errCode: String?,
      private val errMess: String?,
      private val resource: T? = null
   ) : Resource<T>(Status.ERROR, resource, errCode, errMess)

}