package com.stym.assignment.data.models.search


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Albums(
    @SerializedName("href")
    val href: String? = "",
    @SerializedName("items")
    val items: List<Item>? = listOf(),
    @SerializedName("limit")
    val limit: Int? = 0,
    @SerializedName("next")
    val next: String? = "",
    @SerializedName("offset")
    val offset: Int? = 0,
    @SerializedName("total")
    val total: Int? = 0
) : Parcelable