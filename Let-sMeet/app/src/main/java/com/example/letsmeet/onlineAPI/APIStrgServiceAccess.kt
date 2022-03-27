package com.example.letsmeet.onlineAPI

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.letsmeet.Place
import okhttp3.internal.notifyAll
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object APIStrgServiceAccess
{
    private const val BASE_URL = "https://data.strasbourg.eu/api/records/1.0/search/?dataset=lieux_culture"
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
        var apiService : APIStrgService = APIStrgServiceAccess.builder.create(APIStrgService::class.java)
        val call = apiService.getAll()
        call.enqueue(object : Callback<List<Place>>
        {
            override fun onResponse(call: Call<List<Place>>, response: Response<List<Place>>)
            {
                val place = response.body()
                if(place != null)
                {
                    Log.e("API Service Access","API request is successful")
                    placesLive.addAll(place)
                }
            }

            override fun onFailure(call: Call<List<Place>>, t: Throwable)
            {
                Log.e("API Service Access","Request error")
            }
        })
    }
}