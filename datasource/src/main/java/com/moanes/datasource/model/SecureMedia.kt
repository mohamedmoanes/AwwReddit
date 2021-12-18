package com.moanes.datasource.model


import com.google.gson.annotations.SerializedName

data class SecureMedia(
    @SerializedName("reddit_video")
    var redditVideo: RedditVideo
)