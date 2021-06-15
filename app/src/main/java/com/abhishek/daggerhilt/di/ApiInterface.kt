package com.abhishek.daggerhilt.di

import com.abhishek.daggerhilt.data.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/users")
    suspend fun getUsers(): Response<UserResponse>
}