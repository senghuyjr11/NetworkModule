package com.example.network_module.rxjava

class RxEvent {

    class CommentSuccess(val value: String)

    class MGSuccess(val value: String)

    class ResponseSuccess

    class ServerError(val code: Int, val title: String, val message: String)

    class SessionExpired(val title: String, val message: String)
}