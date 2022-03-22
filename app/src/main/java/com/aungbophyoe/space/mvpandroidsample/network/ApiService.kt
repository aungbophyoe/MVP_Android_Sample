package com.aungbophyoe.space.mvpandroidsample.network

import com.aungbophyoe.space.mvpandroidsample.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers() : Response<List<User>>
}