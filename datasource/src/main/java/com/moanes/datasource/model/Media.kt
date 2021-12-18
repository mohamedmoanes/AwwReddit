package com.moanes.datasource.model


import com.google.gson.annotations.SerializedName

data class Media(
    @SerializedName("reddit_video")
    var redditVideo: RedditVideo
)