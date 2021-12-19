package com.moanes.datasource.model


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class Children(
    @SerializedName("data")
    var post: Post,
    @SerializedName("kind")
    var kind: String
)