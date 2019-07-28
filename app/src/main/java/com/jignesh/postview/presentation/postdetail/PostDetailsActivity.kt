package com.jignesh.postview.presentation.postdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.jignesh.domain.models.comment.Comment
import com.jignesh.domain.models.post.Post
import com.jignesh.domain.models.user.User
import com.jignesh.postview.BuildConfig
import com.jignesh.postview.R
import com.jignesh.postview.presentation.base.BaseActivity
import com.jignesh.postview.presentation.utils.getRandomRotation
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_post_details.*
import javax.inject.Inject

class PostDetailsActivity : BaseActivity<PostDetailsPresenter, PostDetailsView>(), PostDetailsView {



    @Inject
    override lateinit var presenter: PostDetailsPresenter

    override var view: PostDetailsView = this
    private lateinit var post:Post
    private lateinit var adapter : PostDetailsAdapter
    override var activityLayout: Int = R.layout.activity_post_details

    companion object {
        fun getIntent(context: Context) = Intent(context, PostDetailsActivity::class.java)
        val POST_OBJECT : String = "post_object"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = getString(R.string.post_details_activity_title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        post = getIntent().getSerializableExtra(POST_OBJECT) as Post
        initialiseAdapater()
        initView()
        presenter.getPostsComments(post.id)
    }

    /// Initialise the adapter ///////
    fun initialiseAdapater(){
        adapter = PostDetailsAdapter()
        recyclerView.adapter = adapter
    }

    private fun initView(){
        avatar.rotation = getRandomRotation()
        Picasso.get()
            .load(post.user?.imageUrl)
            .into(avatar)
        tv_user_name.setText(post.user?.name)
        tv_post_title.setText(post.title)
        tv_post_body.setText(post.body)

    }


    override fun onCommentListingSuccess(comments: List<Comment>) {
        tv_comments.setText(getString(R.string.comments_label) + " ${comments.size}")
        spinKit.visibility= View.GONE
        adapter.comments = comments
        adapter.notifyDataSetChanged()
    }

    override fun onCommentListingFailure() {
        tv_comments.setText(getString(R.string.no_comments_label))
        spinKit.visibility= View.GONE
    }
}