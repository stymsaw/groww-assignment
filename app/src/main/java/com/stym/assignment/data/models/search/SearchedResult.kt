package com.stym.assignment.data.models.search


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class SearchedResult(
    @SerializedName("albums")
    val albums: Albums? = Albums(),
    @SerializedName("artists")
    val artists: Artists? = Artists(),
    @SerializedName("playlists")
    val playlists: Playlists? = Playlists(),
    @SerializedName("tracks")
    val tracks: TracksX? = TracksX()
) : Parcelable