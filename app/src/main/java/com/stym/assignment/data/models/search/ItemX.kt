package com.stym.assignment.data.models.search


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ItemX(
    @SerializedName("external_urls")
    val externalUrls: ExternalUrlsX? = ExternalUrlsX(),
    @SerializedName("followers")
    val followers: Followers? = Followers(),
    @SerializedName("genres")
    val genres: List<String>? = listOf(),
    @SerializedName("href")
    val href: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("images")
    val images: List<Image>? = listOf(),
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("popularity")
    val popularity: Int? = 0,
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("uri")
    val uri: String? = ""
) : Parcelable