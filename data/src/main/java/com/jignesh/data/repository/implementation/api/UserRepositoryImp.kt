package com.jignesh.data.repository.implementation.api


import com.jignesh.data.BuildConfig.BASE_URL_AVATAR
import com.jignesh.data.entity.user.UsersInResponse
import com.jignesh.data.net.user.UserApiClient
import com.jignesh.domain.models.user.User
import com.jignesh.domain.repository.UserRepository
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@SuppressWarnings("")
class UserRepositoryImp @Inject constructor(
    private val userApiClient: UserApiClient
) : UserRepository {


    override fun getUsers(): Single<List<User>> =

        Single.create< List<User>> { observer ->
            userApiClient.api.getUsers().enqueue(object : Callback<List<UsersInResponse>> {

                override fun onFailure(call: Call<List<UsersInResponse>>, t: Throwable) {
                    observer.onError(t)
                }
                override fun onResponse(call: Call<List<UsersInResponse>>, response: Response<List<UsersInResponse>>) {
                    val userModel = mutableListOf<User>()
                    response.body()?.let { responseList ->
                        with(responseList){
                            forEach {
                                userModel.add(
                                    User(
                                        it.id,
                                        it.name,
                                        it.username,
                                        it.email,
                                        it.phone,
                                        it.website,
                                        BASE_URL_AVATAR + "${it.id}.png",
                                        User.Address(
                                            it.address.street,
                                            it.address.suite,
                                            it.address.city,
                                            it.address.zipcode,
                                            User.Address.Geo(
                                                it.address.geo.lat,
                                                it.address.geo.lng
                                            )
                                        ),
                                        User.Company(
                                            it.company.name,
                                            it.company.catchPhrase,
                                            it.company.bs
                                        )
                                    )
                                )
                            }
                        }
                        observer.onSuccess(userModel)

                    }?: observer.onError(Throwable("Empty user response"))

                }
            });
        }


}