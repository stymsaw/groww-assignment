package com.stym.assignment.data.models.search


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ExternalIds(
    @SerializedName("isrc")
    val isrc: String? = null
) : Parcelable