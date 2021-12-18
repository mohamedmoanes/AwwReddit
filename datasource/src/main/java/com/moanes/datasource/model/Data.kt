package com.moanes.datasource.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("after")
    var after: String,
    @SerializedName("before")
    var before: Any?,
    @SerializedName("children")
    var children: List<Children>,
    @SerializedName("dist")
    var dist: Int,
    @SerializedName("geo_filter")
    var geoFilter: String,
    @SerializedName("modhash")
    var modhash: String
)