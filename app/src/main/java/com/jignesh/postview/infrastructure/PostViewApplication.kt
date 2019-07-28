package com.jignesh.postview.infrastructure

import com.jignesh.postview.infrastructure.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class PostViewApplication : DaggerApplication() {

    val injector =   DaggerAppComponent.builder()
            .application(this)
            .build()

    override fun onCreate() {
        super.onCreate()
        injector.inject(this)
    }

    override fun applicationInjector() = injector
}