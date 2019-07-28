package com.jignesh.data.entity.post

import com.google.gson.annotations.SerializedName

class PostsInResponse (
    @SerializedName("userId")val userId : Int,
    @SerializedName("id")val id : Int,
    @SerializedName("title")val title : String = "",
    @SerializedName("body")val body : String = ""
)