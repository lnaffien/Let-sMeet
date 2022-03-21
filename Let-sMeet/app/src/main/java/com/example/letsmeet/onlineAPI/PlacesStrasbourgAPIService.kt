package com.example.letsmeet.onlineAPI

import android.util.Log
import com.example.letsmeet.Place
import com.example.letsmeet.R
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.gson.GsonConverterFactory.*
import retrofit2.http.GET

interface PlacesStrasbourgAPIService
{
    @GET("&q=")
    suspend fun getAllPlaces() : Response<List<Place>>

    companion object
    {
        var retrofitService: PlacesStrasbourgAPIService? = null
        fun getInstance() : PlacesStrasbourgAPIService
        {
            if (retrofitService == null)
            {
                val retrofit = Retrofit.Builder()
                    .baseUrl(R.string.api_key_strasbourg.toString())
                    .addConverterFactory(create())
                    .build()
                retrofitService = retrofit.create(PlacesStrasbourgAPIService::class.java)
                Log.e("API Service","API service created")
            }
            Log.e("API Service","API service accessed")
            return retrofitService!!
        }

    }
}