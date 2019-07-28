package com.jignesh.postview.infrastructure.di.module

import com.jignesh.data.executor.JobExecutor
import com.jignesh.data.repository.implementation.api.CommentRepositoryImp
import com.jignesh.data.repository.implementation.api.PostRepositoryImp
import com.jignesh.data.repository.implementation.api.UserRepositoryImp
import com.jignesh.domain.executor.ThreadExecutor
import com.jignesh.domain.repository.CommentRepository
import com.jignesh.domain.repository.PostRepository
import com.jignesh.domain.repository.UserRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun postRepository(postRespositoryImp: PostRepositoryImp): PostRepository

    @Binds
    abstract fun userRepository(userRespository: UserRepositoryImp): UserRepository

    @Binds
    abstract fun commentRepository(commentRepository: CommentRepositoryImp): CommentRepository

    @Binds
    abstract fun bindThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor
}