package com.jignesh.data.repository.datasources.api.user

import com.jignesh.data.entity.user.UsersInResponse
import retrofit2.Call
import retrofit2.http.GET

interface UserApi{
    @GET("users")
    fun getUsers(
    ): Call<List<UsersInResponse>>
}