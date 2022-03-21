package com.example.letsmeet.temp

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.letsmeet.*

class APIStrgAdapter : RecyclerView.Adapter<APIStrgViewHolder>()
{
    private var places = mutableListOf<Place>()

    fun setPlacesList(places: List<Place>)
    {
        this.places = places.toMutableList()
        notifyDataSetChanged()
    }

    fun addPlace(place : Place)
    {
        this.places.add(place)
        notifyDataSetChanged()
    }

    fun addPlaceList(listPlaces : ArrayList<Place>)
    {
        this.places.addAll(listPlaces)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): APIStrgViewHolder
    {
        val binding = parent.inflate(R.layout.adapter_places, false)
        return APIStrgViewHolder(binding)
    }

    override fun onBindViewHolder(holder: APIStrgViewHolder, position: Int)
    {
        val place = places[position]
        holder.bindPlace(places[position])
    }



        override fun getItemCount() = places.size

}

