package com.jignesh.postview.Test

import androidx.test.platform.app.InstrumentationRegistry
import com.jignesh.postview.inject.component.DaggerTestAppComponent
import com.jignesh.postview.inject.component.TestAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class TestApplication : DaggerApplication() {
    private lateinit var appComponent: TestAppComponent

    companion object {
        fun appComponent(): TestAppComponent {
            return (InstrumentationRegistry.getInstrumentation().getTargetContext().applicationContext as TestApplication).appComponent
        }
    }


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerTestAppComponent.builder().application(this).build()
        return appComponent
    }
}