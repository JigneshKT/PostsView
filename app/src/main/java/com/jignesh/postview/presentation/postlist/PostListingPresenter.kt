package com.jignesh.postview.presentation.postlist

import com.jignesh.domain.models.post.Post
import com.jignesh.domain.usecase.post.GetUsersPostsUseCase
import com.jignesh.postview.presentation.base.Presenter
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class PostListingPresenter @Inject constructor(
    private val getUsersPostsUseCase: GetUsersPostsUseCase
) : Presenter<PostListingView>() {

    fun getUsersPosts(){
        getUsersPostsUseCase.execute(Subscriber(), GetUsersPostsUseCase.Params());
    }

    internal fun handleSuccess(posts: List<Post>) {
        view?.onPostListingSuccess(posts)
    }


    inner class Subscriber : DisposableSingleObserver<List<Post>>() {
        override fun onSuccess(posts: List<Post>) = handleSuccess(posts)

        override fun onError(e: Throwable) {
            view?.onPostListingFailure()
        }
    }

}