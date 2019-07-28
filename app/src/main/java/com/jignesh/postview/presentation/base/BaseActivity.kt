package com.jignesh.postview.presentation.base

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.LayoutRes
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<P : Presenter<V>, V : View> : DaggerAppCompatActivity(), View {

    protected open lateinit var presenter: P
    protected open lateinit var view: V
    @set:LayoutRes
    abstract var activityLayout: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityLayout)
        presenter.init(view)
    }

    override fun onDestroy() {
        presenter.clear()
        super.onDestroy()
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}