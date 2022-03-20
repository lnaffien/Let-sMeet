package com.example.letsmeet.onlineAPI

import retrofit2.http.GET

interface PlacesStrasbourgAPI
{
    val lang : String

    @GET("")
    fun getAll() : String

}