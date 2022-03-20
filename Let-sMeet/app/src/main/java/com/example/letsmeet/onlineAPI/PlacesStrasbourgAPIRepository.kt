package com.example.letsmeet.onlineAPI

import android.util.Log
import com.example.letsmeet.Place
import retrofit2.Response

class PlacesStrasbourgAPIRepository constructor(private val api : PlacesStrasbourgAPIService)
{
    suspend fun getAllPlaces() : Response<List<Place>>
    {
        Log.e("API Repository","API request sended")
        return api.getAllPlaces()
    }
}