package com.husseinhj.customerinfoapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import com.husseinhj.customerinfoapp.data.remote.dto.UserListDto
import com.husseinhj.customerinfoapp.data.remote.dto.UserDetailDto

interface UserApiService {

    @GET("users")
    suspend fun getUsers(): UserListDto

    @GET("users/{id}")
    suspend fun getUser(@Path("id") id: Int): UserDetailDto

}