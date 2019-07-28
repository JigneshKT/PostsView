package com.jignesh.domain.repository

import com.jignesh.domain.models.comment.Comment
import io.reactivex.Single

interface CommentRepository{
    fun getComments(postId:Int) : Single<List<Comment>>
}