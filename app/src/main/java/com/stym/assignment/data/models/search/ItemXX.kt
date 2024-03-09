package com.stym.assignment.data.models.search


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ItemXX(
    @SerializedName("collaborative")
    val collaborative: Boolean? = false,
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("external_urls")
    val externalUrls: ExternalUrlsX? = ExternalUrlsX(),
    @SerializedName("href")
    val href: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("images")
    val images: List<Image>? = listOf(),
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("owner")
    val owner: Owner? = Owner(),
    @SerializedName("snapshot_id")
    val snapshotId: String? = "",
    @SerializedName("tracks")
    val tracks: Tracks? = Tracks(),
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("uri")
    val uri: String? = ""
) : Parcelable