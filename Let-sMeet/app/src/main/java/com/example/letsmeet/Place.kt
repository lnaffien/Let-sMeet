package com.example.letsmeet

import android.util.Log
import java.util.regex.Pattern

data class Place (val accessForWheelchair : Int?,
                  val images : String?,
                  val description : String,
                  val accessfordeaf : Int,
                  val types : String,
                  val accessforblind : Int,
                  val accessforelder : Int,
                  val address : String,
                  val access : String?,
                  val name : String,
                  val friendlyurl : String?,
                  val accessfordeficient : Int,
                  val serviceandactivities : String?,
                  val point_geo : ArrayList<Float>)
{
    fun getImages() : ArrayList<String>?
    {
        var imagesArrayListTemp = ArrayList<String>()
        var imagesArrayListResult = ArrayList<String>()

        if (images != null)
        {
            imagesArrayListTemp = (images.split("\"")).toCollection(ArrayList())
        }

        for(str in imagesArrayListTemp)
        {
            if(str.split("/")[0] == "https:")
            {
                imagesArrayListResult.add(str)
            }
        }
        return imagesArrayListResult
    }

    /*
    "[
        {
            \"imageURL\": \"https://www.strasbourg.eu/documents/20160/2136991/0/708ccf0d-52df-259e-033a-01627b6c3389\",
            \"imageCopyright\": \"D. Cassaz / Ville et Eurométropole de Strasbourg\"
        },
        {
            \"imageURL\": \"https://www.strasbourg.eu/documents/20160/2136991/0/fb0d4592-d865-4b2f-77b9-bbed9543b224\",
             \"imageCopyright\": \"D. Cassaz / Ville et Eurométropole de Strasbourg\"
        }
     ]"
     */
}