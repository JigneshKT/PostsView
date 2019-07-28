package com.jignesh.domain.mapper

import com.jignesh.domain.models.post.Post
import com.jignesh.domain.models.user.User
import javax.inject.Inject

open class UserToPostMapper @Inject constructor() : Mapper<Post, List<User>,Post> {
    override fun mapIt(users: List<User>, post:Post): Post {

        users.let {userList->
            with(userList) {
                forEach {
                    if(it.id == post.user_id){
                        post.user=it
                        return post
                    }
                }
            }
        }

        return post

    }
}