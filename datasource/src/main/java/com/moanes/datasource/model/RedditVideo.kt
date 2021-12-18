package com.moanes.datasource.model


import com.google.gson.annotations.SerializedName

data class RedditVideo(
    @SerializedName("bitrate_kbps")
    var bitrateKbps: Int,
    @SerializedName("dash_url")
    var dashUrl: String,
    @SerializedName("duration")
    var duration: Int,
    @SerializedName("fallback_url")
    var fallbackUrl: String,
    @SerializedName("height")
    var height: Int,
    @SerializedName("hls_url")
    var hlsUrl: String,
    @SerializedName("is_gif")
    var isGif: Boolean,
    @SerializedName("scrubber_media_url")
    var scrubberMediaUrl: String,
    @SerializedName("transcoding_status")
    var transcodingStatus: String,
    @SerializedName("width")
    var width: Int
)