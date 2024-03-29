package com.example.network_module.network

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.network_module.error.ErrorCode
import com.example.network_module.error.Resource
import com.example.network_module.rxjava.RxEvent
import com.example.network_module.rxjava.RxJava
import io.reactivex.plugins.RxJavaPlugins
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.net.ConnectException
import java.net.UnknownHostException

abstract class RemoteDataSource<T> @MainThread constructor() {

    private val result = MutableLiveData<Resource<T>>()

    private fun setValue(newValue: Resource<T>) {
        if (result.value != newValue) {
            result.postValue(newValue)
        }
    }

    suspend fun networkRequest() {
        setValue(Resource.Loading())
        withContext(Dispatchers.IO) {
            when (val response = RetrofitRequest.handleNetworkRequest { createCall() }) {
                is RetrofitResponse.Success -> {
                    RxJava.publish(RxEvent.ResponseSuccess())
                    RxJavaPlugins.setErrorHandler(Throwable::printStackTrace)

                    setValue(Resource.Success(response.body))
                }
                is RetrofitResponse.Exception -> {
                    var code = ErrorCode.SERVICE_ERROR
                    val throwable = response.throwable
                    if (throwable is CancellationException) {
                        return@withContext
                    } else {
                        if (throwable is UnknownHostException || throwable is ConnectException) {
                            // Unknown Error
                            code = ErrorCode.UNKNOWN_ERROR
                        }
                        setValue(Resource.Error(code, ""))
                    }
                }
                is RetrofitResponse.Error -> {
                    setValue(Resource.Error(response.code, response.message))
                }
            }
        }
    }

    fun asLiveData() = result as LiveData<Resource<T>>

    @MainThread
    protected abstract suspend fun createCall(): Response<T>
}