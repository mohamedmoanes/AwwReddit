package com.moanes.datasource.model


import com.google.gson.annotations.SerializedName

data class PostsResponse(
    @SerializedName("data")
    var data: Data,
    @SerializedName("kind")
    var kind: String
)