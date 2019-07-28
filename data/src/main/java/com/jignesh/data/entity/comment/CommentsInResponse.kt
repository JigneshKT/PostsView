package com.jignesh.data.entity.comment

import com.google.gson.annotations.SerializedName

class CommentsInResponse (
    @SerializedName("postId")val postId : Int,
    @SerializedName("id")val id : Int,
    @SerializedName("name")val name : String = "",
    @SerializedName("email")val email : String = "",
    @SerializedName("body")val body : String = ""
)