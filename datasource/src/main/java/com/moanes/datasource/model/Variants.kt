package com.moanes.datasource.model


import com.google.gson.annotations.SerializedName

data class Variants(
    @SerializedName("gif")
    var gif: Gif,
    @SerializedName("mp4")
    var mp4: Mp4
)