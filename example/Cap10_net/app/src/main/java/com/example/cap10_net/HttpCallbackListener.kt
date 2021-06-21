package com.example.cap10_net

interface HttpCallbackListener {
    fun onFinish(response: String)
    fun onError(e: Exception)
}