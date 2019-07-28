package com.jignesh.domain.usecase.post

import com.jignesh.domain.executor.PostExecutionThread
import com.jignesh.domain.executor.ThreadExecutor
import com.jignesh.domain.mapper.UserToPostMapper
import com.jignesh.domain.models.post.Post
import com.jignesh.domain.models.user.User
import com.jignesh.domain.repository.PostRepository
import com.jignesh.domain.repository.UserRepository
import com.jignesh.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import javax.inject.Inject

open class GetUsersPostsUseCase @Inject constructor(
                                        private val postRepository: PostRepository,
                                        private val userRepository: UserRepository,
                                        private val userToPostMapper: UserToPostMapper,
                                        threadExecutor: ThreadExecutor,
                                        postExecutionThread: PostExecutionThread
)
    : SingleUseCase<List<Post>, GetUsersPostsUseCase.Params>(threadExecutor, postExecutionThread) {
    public override fun buildUseCaseObservable(params: Params): Single<List<Post>> {
       return Single.zip(postRepository.getPosts().onErrorReturn { emptyList() }, userRepository.getUsers().onErrorReturn { emptyList() },
            BiFunction { postList, userList -> linkUserToPost(postList, userList) })
    }

    private fun linkUserToPost(posts: List<Post>, users : List<User>)
            :List<Post> {

        posts.let {postList->
            with(postList) {
                forEach {
                    userToPostMapper.mapIt(users,it)
                }
            }
        }
        return posts
    }
    class Params()

}