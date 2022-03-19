package com.example.letsmeet.onlineAPI

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

public class ServiceGenerator
{
    private val URL = "https://data.strasbourg.eu/api/records/1.0/search/?dataset=lieux_culture&q="
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(URL)
        .build()
}