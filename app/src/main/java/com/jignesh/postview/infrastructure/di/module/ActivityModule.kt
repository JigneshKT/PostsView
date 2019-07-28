package com.jignesh.postview.infrastructure.di.module

import com.jignesh.domain.executor.PostExecutionThread
import com.jignesh.postview.executor.UiThread
import com.jignesh.postview.infrastructure.di.scope.ViewScope
import com.jignesh.postview.presentation.postdetail.PostDetailsActivity
import com.jignesh.postview.presentation.postlist.PostListingActivity
import com.jignesh.postview.presentation.splash.SplashActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ViewScope
    @ContributesAndroidInjector
    abstract fun splashActivityInjector(): SplashActivity

    @ViewScope
    @ContributesAndroidInjector
    abstract fun postListActivityInjector(): PostListingActivity

    @ViewScope
    @ContributesAndroidInjector
    abstract fun postDetailsActivityInjector(): PostDetailsActivity

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread
}