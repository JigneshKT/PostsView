package com.jignesh.domain.models.post

import com.jignesh.domain.models.user.User
import java.io.Serializable

data class Post(val id : Int,
                val title: String,
                val body: String,
                val user_id: Int,
                var user: User?
): Serializable