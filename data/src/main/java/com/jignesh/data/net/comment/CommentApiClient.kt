package com.jignesh.data.net.comment

import com.jignesh.data.BuildConfig
import com.jignesh.data.net.BaseHttpClient
import com.jignesh.data.repository.datasources.api.comment.CommentApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class CommentApiClient @Inject constructor(baseHttpClient: BaseHttpClient) {
    val api: CommentApi = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL_POST)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(baseHttpClient.getClient())
        .build()
        .create(CommentApi::class.java)

}