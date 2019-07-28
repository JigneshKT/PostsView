package com.jignesh.postview.infrastructure.di.component

import com.jignesh.postview.infrastructure.PostViewApplication
import com.jignesh.postview.infrastructure.di.module.ActivityModule
import com.jignesh.postview.infrastructure.di.module.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityModule::class,
    RepositoryModule::class
])
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: PostViewApplication): Builder

        fun build(): AppComponent
    }

    fun inject(application: PostViewApplication)
}