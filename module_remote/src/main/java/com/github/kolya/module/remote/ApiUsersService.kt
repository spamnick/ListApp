package com.github.kolya.module.remote

import com.github.kolya.module.remote.models.UserRemote
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiUsersService {
    @GET("/users")
    suspend fun getUsers(): List<UserRemote>
    @GET("/users/{username}")
    suspend fun getUserByUserName(@Path("username")username:String): UserRemote
}