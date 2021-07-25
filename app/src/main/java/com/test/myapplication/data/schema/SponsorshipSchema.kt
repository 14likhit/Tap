package com.test.myapplication.data.schema

import com.google.gson.annotations.SerializedName

data class SponsorshipSchema(
    @SerializedName("impression_urls") var impressionUrls: List<String>?,
    @SerializedName("tagline") var tagline: String?,
    @SerializedName("tagline_url") var taglineUrl: String?
)
