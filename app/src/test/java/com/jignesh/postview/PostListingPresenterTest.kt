package com.jignesh.postview

import com.jignesh.domain.models.post.Post
import com.jignesh.domain.usecase.post.GetUsersPostsUseCase
import com.jignesh.postview.model.getExpectedPostList
import com.jignesh.postview.presentation.postlist.PostListingPresenter
import com.jignesh.postview.presentation.postlist.PostListingView
import com.nhaarman.mockito_kotlin.*
import io.reactivex.observers.DisposableSingleObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PostListingPresenterTest {

    private lateinit var postListingPresenter: PostListingPresenter

    private lateinit var argumentCaptor: KArgumentCaptor<DisposableSingleObserver<List<Post>>>

    @Mock
    private lateinit var getUsersPostsUseCase: GetUsersPostsUseCase

    @Mock
    private lateinit var postListingView: PostListingView


    @Before
    fun setUp() {
        argumentCaptor = argumentCaptor()
        postListingPresenter = PostListingPresenter(getUsersPostsUseCase)
        postListingPresenter.init(postListingView)
    }

    @Test
    fun `getUsersPosts should call onPostListingSuccess`() {

        val postList:List<Post> = getExpectedPostList()
        whenever(getUsersPostsUseCase.execute(argumentCaptor.capture(),any())).doAnswer { argumentCaptor.firstValue.onSuccess(postList) }
        postListingPresenter.getUsersPosts()

        verify(postListingPresenter.view)?.onPostListingSuccess(postList)
        verify(postListingPresenter.view, never())?.onPostListingFailure()
    }

    @Test
    fun `getUsersPosts should call onPostListingFailure`() {

        whenever(getUsersPostsUseCase.execute(argumentCaptor.capture(),any())).doAnswer { argumentCaptor.firstValue.onError(
            Throwable("Unknown error")
        ) }
        postListingPresenter.getUsersPosts()

        verify(postListingPresenter.view)?.onPostListingFailure()
        verify(postListingPresenter.view, never())?.onPostListingSuccess(any())
    }
}