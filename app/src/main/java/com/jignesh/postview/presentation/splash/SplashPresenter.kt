package com.jignesh.postview.presentation.splash

import com.jignesh.domain.usecase.post.GetUsersPostsUseCase
import com.jignesh.postview.presentation.base.Presenter
import javax.inject.Inject

class SplashPresenter @Inject constructor(
    private val getUsersPostsUseCase: GetUsersPostsUseCase
) : Presenter<SplashView>() {
}