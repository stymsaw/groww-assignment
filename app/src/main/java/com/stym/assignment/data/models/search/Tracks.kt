package com.stym.assignment.data.models.search


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Tracks(
    @SerializedName("href")
    val href: String? = null,
    @SerializedName("total")
    val total: Int? = null
) : Parcelable