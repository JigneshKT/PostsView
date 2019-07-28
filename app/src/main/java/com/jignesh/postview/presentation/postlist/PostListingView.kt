package com.jignesh.postview.presentation.postlist

import com.jignesh.postview.presentation.base.View
import com.jignesh.domain.models.post.Post

interface PostListingView : View {
    fun onPostListingSuccess(posts:List<Post>)
    fun onPostListingFailure()
}