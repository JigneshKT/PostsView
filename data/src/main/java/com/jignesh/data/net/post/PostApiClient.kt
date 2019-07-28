package com.jignesh.data.net.post

import com.jignesh.data.BuildConfig.BASE_URL_POST
import com.jignesh.data.net.BaseHttpClient
import com.jignesh.data.repository.datasources.api.post.PostApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class PostApiClient @Inject constructor(baseHttpClient: BaseHttpClient) {
    val api: PostApi = Retrofit.Builder()
        .baseUrl(BASE_URL_POST)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(baseHttpClient.getClient())
        .build()
        .create(PostApi::class.java)

}