package com.jignesh.domain.model

import com.jignesh.domain.models.post.Post
import com.jignesh.domain.models.user.User

fun getExpectedPostList() = listOf(getExpectedPost())
fun getExpectedUserList() = listOf(getExpectedUserModel())

fun getExpectedPost(): Post = Post(1,
    "title",
    "body",
    1,
    getExpectedUserModel()
)


fun getExpectedUserModel(): User {
    return User(
        id = 1,
        name = "name",
        username = "username",
        email = "email",
        phone = "phone",
        website = "website",
        imageUrl = "imageUrl",
        adddress = getExpectedAddress(),
        company = getExpectedCompany()
    )
}


fun getExpectedAddress(): User.Address{
    return User.Address(
        street = "street",
        suite= "suite",
        city  = "city",
        zipcode = "zipcode",
        geo = getExpectedGeo()
    )
}

fun getExpectedGeo(): User.Address.Geo{
    return User.Address.Geo(
        lat  = "lat",
        lng  = "lng"
    )
}

fun getExpectedCompany(): User.Company {
    return User.Company(
        name = "name",
        catchPhrase = "catchPhrase",
        bs = "bs"
    )
}