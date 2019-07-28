package com.jignesh.data

import com.jignesh.data.entity.user.UsersInResponse
import com.jignesh.data.repository.datasources.api.user.UserApi
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response






class UserApiMock (val responseCase: ResponseCase, val responseData: List<UsersInResponse>) : UserApi {


    enum class ResponseCase {
        success,
        failure
    }

    override fun getUsers(): Call<List<UsersInResponse>> {
        return object : Call<List<UsersInResponse>> {

            override fun enqueue(callback: Callback<List<UsersInResponse>>?) {

                if (responseCase == ResponseCase.success)
                    callback?.onResponse(this, Response.success(responseData));
                else
                    callback?.onFailure(this,  Throwable("Failed to fetch users"));
            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun clone(): Call<List<UsersInResponse>> {
                return this
            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun request(): Request {
                return Request.Builder().build()
            }

            override fun execute(): Response<List<UsersInResponse>> {
                return Response.success(emptyList())
            }

        }
    }
}
