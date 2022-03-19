package com.example.letsmeet.onlineAPI

import retrofit2.http.GET

interface PlacesStrasbourgAPI
{
    val lang : String

    @GET("types")
    fun getTypes() : String

     @GET("name")
     fun getName() : String

     @GET("address")
     fun getAddress() : String

     @GET("access")
     fun getAccess() : String

     @GET("friendlyURL")
     fun getURL() : String

     @GET("description")
     fun getDescription() : String

}