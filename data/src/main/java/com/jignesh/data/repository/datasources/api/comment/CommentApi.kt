package com.jignesh.data.repository.datasources.api.comment

import com.jignesh.data.entity.comment.CommentsInResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CommentApi{
    @GET("comments")
    fun getComments(
        @Query("postId") postId: Int
        ): Call<List<CommentsInResponse>>
}