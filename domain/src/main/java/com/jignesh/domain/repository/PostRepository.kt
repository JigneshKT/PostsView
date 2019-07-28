package com.jignesh.domain.repository

import com.jignesh.domain.models.post.Post
import io.reactivex.Single

interface PostRepository{
        fun getPosts() : Single<List<Post>>
}