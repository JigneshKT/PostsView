package com.jignesh.postview.presentation.postdetail

import com.jignesh.domain.models.comment.Comment
import com.jignesh.domain.usecase.comment.GetCommentsUseCase
import com.jignesh.postview.presentation.base.Presenter
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class PostDetailsPresenter @Inject constructor(
    private val getCommentsUseCase: GetCommentsUseCase
) : Presenter<PostDetailsView>() {

    fun getPostsComments(postId:Int){
        getCommentsUseCase.execute(Subscriber(), GetCommentsUseCase.Params(postId));
    }

    internal fun handleSuccess(comments: List<Comment>) {
        view?.onCommentListingSuccess(comments)
    }


    inner class Subscriber : DisposableSingleObserver<List<Comment>>() {
        override fun onSuccess(t: List<Comment>) = handleSuccess(t)

        override fun onError(e: Throwable) {
            view?.onCommentListingFailure()
        }
    }

}