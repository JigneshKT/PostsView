package com.jignesh.data.repository.datasources.api.post

import com.jignesh.data.entity.post.PostsInResponse
import retrofit2.Call
import retrofit2.http.GET

interface PostApi {
    @GET("posts")
    fun getPosts(
    ): Call<List<PostsInResponse>>
}