package com.example.letsmeet.onlineAPI

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.letsmeet.APIStrgModels.APIStrg
import com.example.letsmeet.Place
import okhttp3.internal.notifyAll
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.typeOf


object APIStrgServiceAccess
{
    private const val BASE_URL = "https://data.strasbourg.eu/api/records/1.0/search/"
    private var retrofitInstance : Retrofit? = null
    var placesLive : MutableList<Place> = ArrayList()

    val builder : Retrofit
        get()
        {
            if(retrofitInstance == null)
            {
                retrofitInstance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return this.retrofitInstance!!
        }

    fun getAll()
    {
        Log.e("API Service Access","API request sent")
        var apiService : APIStrgService = builder.create(APIStrgService::class.java)
        val call = apiService.getAll()
        call.enqueue(object : Callback<APIStrg>
        {
            override fun onResponse(call: Call<APIStrg>, response: Response<APIStrg>)
            {
                val apiStrg = response.body()
                if(apiStrg != null)
                {
                    Log.e("API Service Access","API request is successful")
                    for (apiStrgInfos in apiStrg.records)
                    {
                        //Log.i("API Service Access", apiStrgInfos.fields.name)
                        placesLive.add(apiStrgInfos.fields)
                    }
                }
                else
                {
                    Log.e("API Service Access","API response is empty")
                }
            }

            override fun onFailure(call: Call<APIStrg>, t: Throwable)
            {
                Log.e("API Service Access","Request error")
            }
        })
    }
}