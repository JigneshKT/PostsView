package com.jignesh.data.net.user

import com.jignesh.data.BuildConfig.BASE_URL_POST
import com.jignesh.data.net.BaseHttpClient
import com.jignesh.data.repository.datasources.api.user.UserApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class UserApiClient @Inject constructor(baseHttpClient: BaseHttpClient) {
    val api: UserApi = Retrofit.Builder()
        .baseUrl(BASE_URL_POST)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(baseHttpClient.getClient())
        .build()
        .create(UserApi::class.java)

}