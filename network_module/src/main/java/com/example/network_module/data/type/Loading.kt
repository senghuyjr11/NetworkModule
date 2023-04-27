package com.example.network_module.data.type

sealed class Loading(var dismiss: Boolean){

    companion object {
        const val LOADING = true
    }

    object Allow: Loading(LOADING)
}
