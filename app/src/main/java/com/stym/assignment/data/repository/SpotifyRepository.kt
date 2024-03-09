package com.stym.assignment.data.repository

import com.stym.assignment.BaseApplication
import com.stym.assignment.data.models.search.SearchedResult
import com.stym.assignment.data.models.token.AccessToken
import com.stym.assignment.data.retrofit.SpotifyAPI
import com.stym.assignment.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SpotifyRepository @Inject constructor(
    private val spotifyAPI: SpotifyAPI,
) {

    private val _accessToken = MutableStateFlow(AccessToken())
    private val _searchedResult = MutableStateFlow(SearchedResult())

    val accessToken: StateFlow<AccessToken>
        get() = _accessToken
    val searchedResult: StateFlow<SearchedResult>
        get() = _searchedResult


    init {
        CoroutineScope(Dispatchers.IO).launch {
            getAccessToken()
        }
    }

    private suspend fun getAccessToken() {
        val response = spotifyAPI.getAccessToken(
            Constants.ACCESS_TOKEN_URL,
            grantType = "client_credentials",
            clientId = "d4f33823860d4ec7ba20490f00d26e77",
            clientSecret = "59fc1c20038c422399b8fd28e4ff20d7"
        )
        try {
            if (response.isSuccessful && response.body() != null) {
                val accessToken = response.body()!!
                BaseApplication.saveAccessToken(accessToken.accessToken)
            }
        } catch (e: Exception) {
            println(e)
        }

    }

    suspend fun getSearchedResult(
        query: String, type: String, authToken: String

    ) {
        val response =
            spotifyAPI.getSearchedResult(
                query = query,
                type = type,
                limit = "20",
                authorization = authToken
            )

        response;
        response;
    }
//        try {
//
//            if (response.isSuccessful && response.body() != null){
//                val b = response.body()!!
//                _searchedResult.emit(response.body()!!)
//            }
//            else
//                response;
//        }
//        catch (e:Exception){
//            println(e)
//        }
//
//    }


}