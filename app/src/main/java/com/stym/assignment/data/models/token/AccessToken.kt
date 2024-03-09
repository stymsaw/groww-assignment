package com.stym.assignment.data.models.token


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class AccessToken(
    @SerializedName("access_token")
    val accessToken: String = "",
    @SerializedName("expires_in")
    val expiresIn: Int = -1,
    @SerializedName("token_type")
    val tokenType: String = ""
) : Parcelable