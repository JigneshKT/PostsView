package com.jignesh.data

import com.jignesh.data.entity.user.UsersInResponse
import com.jignesh.domain.models.user.User

fun getUserModel():UsersInResponse{
    return UsersInResponse (
        id = 1 ,
        name = "name",
        username = "username",
        email = "email",
        phone = "phone",
        website = "website",
        address = getAddress(),
        company = getCompany()
    )
}

fun getAddress(): UsersInResponse.Address{
    return UsersInResponse.Address(
        street = "street",
        suite= "suite",
        city  = "city",
        zipcode = "zipcode",
        geo = getGeo()
    )
}

fun getGeo(): UsersInResponse.Address.Geo{
    return UsersInResponse.Address.Geo(
        lat  = "lat",
        lng  = "lng"
    )
}

fun getCompany():UsersInResponse.Company {
    return UsersInResponse.Company(
        name = "name",
        catchPhrase = "catchPhrase",
        bs = "bs"
    )
}




fun getExpectedUserModel():User{
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

fun getExpectedCompany():User.Company {
    return User.Company(
        name = "name",
        catchPhrase = "catchPhrase",
        bs = "bs"
    )
}
