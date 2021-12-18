package com.moanes.datasource.model


import com.google.gson.annotations.SerializedName

data class Preview(
    @SerializedName("enabled")
    var enabled: Boolean,
    @SerializedName("images")
    var images: List<Image>,
    @SerializedName("reddit_video_preview")
    var redditVideoPreview: RedditVideoPreview
)