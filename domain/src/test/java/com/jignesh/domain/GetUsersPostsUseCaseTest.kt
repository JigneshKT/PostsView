package com.jignesh.domain

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import com.jignesh.domain.executor.PostExecutionThread
import com.jignesh.domain.executor.ThreadExecutor
import com.jignesh.domain.mapper.UserToPostMapper
import com.jignesh.domain.model.getExpectedPostList
import com.jignesh.domain.model.getExpectedUserList
import com.jignesh.domain.models.post.Post
import com.jignesh.domain.models.user.User
import com.jignesh.domain.repository.PostRepository
import com.jignesh.domain.repository.UserRepository
import com.jignesh.domain.usecase.post.GetUsersPostsUseCase
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class GetUsersPostsUseCaseTest {
    private lateinit var useCase: GetUsersPostsUseCase

    private lateinit var mockThreadExecutor: ThreadExecutor
    private lateinit var mockPostExecutionThread: PostExecutionThread
    private lateinit var mockUserRepository: UserRepository
    private lateinit var mockPostRepository: PostRepository
    private lateinit var mockUserToPostMapper : UserToPostMapper

    @Before
    fun setUp() {
        mockThreadExecutor = mock()
        mockPostExecutionThread = mock()
        mockUserRepository = mock()
        mockPostRepository = mock()
        mockUserToPostMapper = mock()

        useCase = GetUsersPostsUseCase(mockPostRepository,mockUserRepository, mockUserToPostMapper,mockThreadExecutor, mockPostExecutionThread)
    }

    @Test
    fun buildUseCaseObservableReturnsData() {
        val posts = getExpectedPostList()
        val users = getExpectedUserList()
        stubGetPosts(Single.just(posts))
        stubGetUsers(Single.just(users))
        val testObserver = useCase.buildUseCaseObservable(GetUsersPostsUseCase.Params()).test()
        testObserver.assertValue(posts)
    }

    private fun stubGetPosts(single: Single<List<Post>>) {
        whenever(mockPostRepository.getPosts())
            .thenReturn(single)
    }

    private fun stubGetUsers(single: Single<List<User>>) {
        whenever(mockUserRepository.getUsers())
            .thenReturn(single)
    }
}