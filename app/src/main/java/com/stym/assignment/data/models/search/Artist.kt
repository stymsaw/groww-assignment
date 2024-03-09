package com.stym.assignment.data.models.search


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Artist(
    @SerializedName("external_urls")
    val externalUrls: ExternalUrlsX? = ExternalUrlsX(),
    @SerializedName("href")
    val href: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("uri")
    val uri: String? = ""
) : Parcelable