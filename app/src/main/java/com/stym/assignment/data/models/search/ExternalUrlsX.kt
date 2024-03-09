package com.stym.assignment.data.models.search


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ExternalUrlsX(
    @SerializedName("spotify")
    val spotify: String? = null
) : Parcelable