package com.jignesh.postview.inject.component

import android.app.Application
import com.jignesh.domain.repository.PostRepository
import com.jignesh.domain.repository.UserRepository
import com.jignesh.postview.infrastructure.di.component.AppComponent
import com.jignesh.postview.infrastructure.di.module.ActivityModule
import com.jignesh.postview.infrastructure.di.module.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityModule::class,
    RepositoryModule::class
])
interface TestAppComponent : AppComponent {
    fun userRepository() : UserRepository
    fun postRepository() : PostRepository

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): TestAppComponent.Builder

        fun build(): TestAppComponent
    }
}