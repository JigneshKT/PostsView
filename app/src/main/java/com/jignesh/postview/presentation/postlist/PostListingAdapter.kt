package com.jignesh.postview.presentation.postlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jignesh.domain.models.post.Post
import com.jignesh.postview.R
import com.jignesh.postview.presentation.utils.getRandomRotation

import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_post_listing.view.*

class PostListingAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    lateinit var mClickListener: OnClickListener;

    fun setOnItemClickListener(aClickListener: OnClickListener) {
        mClickListener = aClickListener
    }

    public interface OnClickListener {
        fun onClick(pos: Int, aView: View)
    }

    var Posts: List<Post> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_post_listing, parent, false)
        return PostListingViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return Posts.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PostListingViewHolder).bind(Posts[position])
    }

    inner class PostListingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {


        override fun onClick(v: View) {
            mClickListener.onClick(adapterPosition, v)
        }


        init {
            itemView.setOnClickListener(this)
        }


        fun bind(post: Post) {
            itemView.avatar.rotation = getRandomRotation()
            itemView.tv_user_name.setText(post.user?.name)
            itemView.tv_post_title.setText(post.title)
            itemView.tv_post_body.setText(post.body)
            Picasso.get()
                .load(post.user?.imageUrl)
                .into(itemView.avatar)
        }
    }
}