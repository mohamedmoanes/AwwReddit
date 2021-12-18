package com.moanes.datasource.model


import com.google.gson.annotations.SerializedName

data class Gif(
    @SerializedName("resolutions")
    var resolutions: List<Resolution>,
    @SerializedName("source")
    var source: Source
)