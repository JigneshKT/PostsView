package com.jignesh.postview.presentation.postdetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jignesh.domain.models.comment.Comment
import com.jignesh.postview.R
import kotlinx.android.synthetic.main.item_post_details.view.*

class PostDetailsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var comments: List<Comment> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_post_details, parent, false)
        return PostDetailsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return comments.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PostDetailsViewHolder).bind(comments[position])
    }

    inner class PostDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(comment: Comment) {
            itemView.tv_comment_name.setText(comment.name)
            itemView.tv_comment_email.setText(comment.email)
            itemView.tv_comment_body.setText(comment.body)

        }
    }
}