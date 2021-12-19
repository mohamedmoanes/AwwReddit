package com.moanes.datasource.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Favorite")
data class Post(
    @SerializedName("id")
    @PrimaryKey
    var id: String,
    @SerializedName("is_video")
    var isVideo: Boolean,
    @SerializedName("thumbnail")
    var thumbnail: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("url")
    var url: String
){}