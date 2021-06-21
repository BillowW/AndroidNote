package com.example.cap10_net

import retrofit2.Call
import retrofit2.http.GET

interface AppService {
    @GET("get_data.json")
    fun getAppData(): Call<List<App>>
}