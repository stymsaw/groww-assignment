package com.stym.assignment.data.models.search


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Item(
    @SerializedName("album_type")
    val albumType: String? = "",
    @SerializedName("artists")
    val artists: List<Artist>? = listOf(),
    @SerializedName("available_markets")
    val availableMarkets: List<String>? = listOf(),
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
    @SerializedName("release_date")
    val releaseDate: String? = "",
    @SerializedName("release_date_precision")
    val releaseDatePrecision: String? = "",
    @SerializedName("total_tracks")
    val totalTracks: Int? = 0,
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("uri")
    val uri: String? = ""
) : Parcelable