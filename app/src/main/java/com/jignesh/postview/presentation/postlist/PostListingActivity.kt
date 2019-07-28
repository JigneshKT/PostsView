package com.jignesh.postview.presentation.postlist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.jignesh.domain.models.post.Post
import com.jignesh.postview.R
import com.jignesh.postview.presentation.base.BaseActivity
import com.jignesh.postview.presentation.postdetail.PostDetailsActivity
import com.jignesh.postview.presentation.postdetail.PostDetailsActivity.Companion.POST_OBJECT
import kotlinx.android.synthetic.main.activity_post_listing.*
import kotlinx.android.synthetic.main.item_loading.*
import javax.inject.Inject
import java.io.Serializable

class PostListingActivity : BaseActivity<PostListingPresenter, PostListingView>(), PostListingView {


    @Inject
    override lateinit var presenter: PostListingPresenter

    override var view: PostListingView = this
    override var activityLayout: Int = R.layout.activity_post_listing

    lateinit var adapter : PostListingAdapter
    lateinit var posts:List<Post>

    companion object {
        fun getIntent(context: Context) = Intent(context, PostListingActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(getString(R.string.post_listing_activity_title));
        initialiseAdapater()
        presenter.getUsersPosts()
    }

    /// Initialise the adapter ///////
    fun initialiseAdapater(){
        adapter = PostListingAdapter()
        recyclerView_post_linking.adapter = adapter
        adapter.setOnItemClickListener(object :PostListingAdapter.OnClickListener{
            override fun onClick(pos: Int, aView: View) {
                val intent = PostDetailsActivity.getIntent(this@PostListingActivity)
                intent.putExtra(POST_OBJECT, posts.get(pos) as Serializable)
                startActivity(intent)
            }
        })
    }


    override fun onPostListingSuccess(posts: List<Post>) {
        hideLoading()
        this.posts = posts
        adapter.Posts = posts
        adapter.notifyDataSetChanged()
    }

    override fun onPostListingFailure() {
        hideLoading()
    }

    private fun hideLoading(){
        ll_item_loading.visibility = View.GONE;
    }
}