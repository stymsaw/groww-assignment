package com.stym.assignment.data.retrofit

import com.stym.assignment.data.models.search.SearchedResult
import com.stym.assignment.data.models.token.AccessToken
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url

interface SpotifyAPI {

    @POST
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    suspend fun getAccessToken(
        @Url url: String,
        @Field("grant_type") grantType: String,
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String
    ): Response<AccessToken>

    @GET("search")
    suspend fun getSearchedResult(
        @Query("q") query: String?,
        @Query("type") type: String?,
        @Query("limit") limit: String?,
        @Header("Authorization") authorization: String?
    ): Response<SearchedResult>


}