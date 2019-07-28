package com.jignesh.data.repository.implementation.api

import com.jignesh.data.entity.comment.CommentsInResponse
import com.jignesh.data.net.comment.CommentApiClient
import com.jignesh.domain.models.comment.Comment
import com.jignesh.domain.repository.CommentRepository
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CommentRepositoryImp @Inject constructor(
    private val commentApiClient: CommentApiClient
) : CommentRepository {


    override fun getComments(postId:Int): Single<List<Comment>> =
        Single.create<List<Comment>> { observer ->
            commentApiClient.api.getComments(postId).enqueue(object : Callback<List<CommentsInResponse>> {
                override fun onFailure(call: Call<List<CommentsInResponse>>, t: Throwable) {
                    observer.onError(t)
                }

                override fun onResponse(call: Call<List<CommentsInResponse>>, response: Response<List<CommentsInResponse>>) {
                    val commentModel = mutableListOf<Comment>()
                    response.body()?.let { responseList ->
                        with(responseList){
                            forEach {
                                commentModel.add(
                                    Comment(
                                        it.postId,
                                        it.id,
                                        it.name,
                                        it.email,
                                        it.body
                                    )
                                )
                            }
                        }
                        observer.onSuccess(commentModel)

                    }?: observer.onError(Throwable("Empty post response"))


                }
            });
        }

}