package com.example.letsmeet.onlineAPI

import com.example.letsmeet.APIStrgModels.APIStrg
import com.example.letsmeet.Place
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIStrgService
{
    @GET("?dataset=lieux_culture&rows=100&q=")
    fun getAll() : Call<APIStrg>

    //https://data.strasbourg.eu/api/records/1.0/search/?dataset=lieux_culture&q=name=maison
}