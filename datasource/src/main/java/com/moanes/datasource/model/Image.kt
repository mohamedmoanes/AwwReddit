package com.moanes.datasource.model


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("id")
    var id: String,
    @SerializedName("resolutions")
    var resolutions: List<Resolution>,
    @SerializedName("source")
    var source: Source,
    @SerializedName("variants")
    var variants: Variants
)