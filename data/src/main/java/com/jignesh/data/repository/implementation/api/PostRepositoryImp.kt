package com.jignesh.data.repository.implementation.api

import com.jignesh.data.entity.post.PostsInResponse
import com.jignesh.data.net.post.PostApiClient
import com.jignesh.domain.models.post.Post
import com.jignesh.domain.repository.PostRepository
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class PostRepositoryImp @Inject constructor(
    private val postApiClient: PostApiClient
) : PostRepository {


    override fun getPosts(): Single<List<Post>> =

        Single.create<List<Post>> { observer ->
            postApiClient.api.getPosts().enqueue(object : Callback<List<PostsInResponse>> {
                override fun onFailure(call: Call<List<PostsInResponse>>, t: Throwable) {
                    observer.onError(t)
                }

                override fun onResponse(call: Call<List<PostsInResponse>>, response: Response<List<PostsInResponse>>) {
                    val postModel = mutableListOf<Post>()
                        response.body()?.let { responseList ->
                            with(responseList){
                                forEach {
                                    postModel.add(
                                        Post(
                                            it.id,
                                            it.title,
                                            it.body,
                                            it.userId,
                                            null
                                        )
                                    )
                                }
                            }
                            observer.onSuccess(postModel)

                        }?: observer.onError(Throwable("Empty post response"))


                }
            });
        }

}