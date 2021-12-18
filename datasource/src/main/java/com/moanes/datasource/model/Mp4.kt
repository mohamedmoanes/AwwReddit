package com.moanes.datasource.model


import com.google.gson.annotations.SerializedName

data class Mp4(
    @SerializedName("resolutions")
    var resolutions: List<Resolution>,
    @SerializedName("source")
    var source: Source
)