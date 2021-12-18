package com.moanes.datasource.model


import com.google.gson.annotations.SerializedName

data class Children(
    @SerializedName("data")
    var post: Post,
    @SerializedName("kind")
    var kind: String
)