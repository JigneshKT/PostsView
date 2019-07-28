package com.jignesh.data


import com.jignesh.data.entity.user.UsersInResponse
import com.jignesh.data.net.user.UserApiClient
import com.jignesh.data.repository.datasources.api.user.UserApi
import com.jignesh.data.repository.implementation.api.UserRepositoryImp
import com.jignesh.domain.models.user.User
import com.nhaarman.mockito_kotlin.*
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call
import retrofit2.Response
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer
import retrofit2.Callback


@RunWith(MockitoJUnitRunner::class)
class UserRepositoryImpTest{

    private lateinit var  userRepositoryImp : UserRepositoryImp

    @Mock
    private lateinit var userApiClient: UserApiClient

    private val response = listOf(getUserModel(),getUserModel())

    private var userApi = UserApiMock(UserApiMock.ResponseCase.success,response)

    @Before
    fun setUp() {
        whenever(userApiClient.api).then { userApi }
        userRepositoryImp = UserRepositoryImp(userApiClient)
    }


    @Test
    fun `get users should return user list`() {
        // when
        val testObserver = userRepositoryImp.getUsers().test()

        // then
        testObserver.assertNoErrors()
        testObserver.assertComplete()
        testObserver.assertValueCount(1)
        val expectedUser : User = getExpectedUserModel()
        testObserver.assertValue {
            it[0].id == expectedUser.id
            it[0].name == expectedUser.name
            it[0].email == expectedUser.email
            it[0].phone == expectedUser.phone
        }
    }

    @Test
    fun `get users should return failure error`() {
        userApi = UserApiMock(UserApiMock.ResponseCase.failure,response)
        // when
        val testObserver = userRepositoryImp.getUsers().test()
        // then
        testObserver.assertError {
            it.message.equals("Failed to fetch users")
        }
    }



}