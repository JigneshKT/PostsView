package com.jignesh.postview.presentation.postdetail

import com.jignesh.domain.models.comment.Comment
import com.jignesh.postview.presentation.base.View

interface PostDetailsView : View {
    fun onCommentListingSuccess(comments:List<Comment>)
    fun onCommentListingFailure()
}