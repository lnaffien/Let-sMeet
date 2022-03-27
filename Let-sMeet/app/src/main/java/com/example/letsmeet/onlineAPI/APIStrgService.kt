package com.example.letsmeet.onlineAPI

import com.example.letsmeet.Place
import retrofit2.Call
import retrofit2.http.GET

interface APIStrgService
{
    @GET(".")
    fun getAll() : Call<List<Place>>
}