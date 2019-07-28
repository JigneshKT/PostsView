package com.jignesh.domain.usecase.comment

import com.jignesh.domain.executor.PostExecutionThread
import com.jignesh.domain.executor.ThreadExecutor
import com.jignesh.domain.mapper.UserToPostMapper
import com.jignesh.domain.models.comment.Comment
import com.jignesh.domain.repository.CommentRepository
import com.jignesh.domain.repository.UserRepository
import com.jignesh.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

open class GetCommentsUseCase @Inject constructor(
    private val commentRepository: CommentRepository,
    private val userRepository: UserRepository,
    private val userToPostMapper: UserToPostMapper,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
)
    : SingleUseCase<List<Comment>, GetCommentsUseCase.Params>(threadExecutor, postExecutionThread) {
    public override fun buildUseCaseObservable(params: Params): Single<List<Comment>> {
        return commentRepository.getComments(params.postId)
    }
    class Params(val postId:Int)

}