package com.stym.assignment

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.stym.assignment.data.retrofit.SpotifyAPI
import com.stym.assignment.utils.Constants
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@HiltAndroidApp
class BaseApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    }


    companion object {

        private const val PREFS_NAME = "MyPrefs"
        private const val ACCESS_TOKEN_KEY = "ACCESS_TOKEN"
        private lateinit var sharedPreferences: SharedPreferences


        fun saveAccessToken(accessToken: String) {
            val editor = sharedPreferences.edit()
            editor.putString(ACCESS_TOKEN_KEY, accessToken)
            editor.apply()
        }

        fun getAccessToken(): String? = sharedPreferences.getString(ACCESS_TOKEN_KEY, null)


        val retrofit: SpotifyAPI = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SpotifyAPI::class.java)

    }


}