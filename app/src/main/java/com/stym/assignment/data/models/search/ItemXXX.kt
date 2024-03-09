package com.stym.assignment.data.models.search


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ItemXXX(
    @SerializedName("album")
    val album: Album? = Album(),
    @SerializedName("artists")
    val artists: List<Artist>? = listOf(),
    @SerializedName("available_markets")
    val availableMarkets: List<String>? = listOf(),
    @SerializedName("disc_number")
    val discNumber: Int? = 0,
    @SerializedName("duration_ms")
    val durationMs: Int? = 0,
    @SerializedName("explicit")
    val explicit: Boolean? = false,
    @SerializedName("external_ids")
    val externalIds: ExternalIds? = ExternalIds(),
    @SerializedName("external_urls")
    val externalUrls: ExternalUrlsX? = ExternalUrlsX(),
    @SerializedName("href")
    val href: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("is_local")
    val isLocal: Boolean? = false,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("popularity")
    val popularity: Int? = 0,
    @SerializedName("preview_url")
    val previewUrl: String? = "",
    @SerializedName("track_number")
    val trackNumber: Int? = 0,
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("uri")
    val uri: String? = ""
) : Parcelable