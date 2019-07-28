package com.jignesh.domain.repository

import com.jignesh.domain.models.user.User
import io.reactivex.Single

interface UserRepository{
    fun getUsers(): Single<List<User>>
}