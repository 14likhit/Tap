package com.test.myapplication.data.schema

import com.google.gson.annotations.SerializedName

data class LinksSchema(
    @SerializedName("self") var self: String?,
    @SerializedName("html") var html: String?,
    @SerializedName("download") var download: String?,
    @SerializedName("download_location") var downloadLocation: String?
)
