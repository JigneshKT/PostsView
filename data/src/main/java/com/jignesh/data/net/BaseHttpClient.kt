package com.jignesh.data.net

import com.jignesh.data.BuildConfig.DEBUG
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Inject

class BaseHttpClient @Inject constructor(

) {

    fun getClient(requireAuthorization: Boolean = true): OkHttpClient {
        val httpBuilder = OkHttpClient()
            .newBuilder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = if (DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                }
            )

        if (requireAuthorization) {

        }

        return httpBuilder.build()
    }

}