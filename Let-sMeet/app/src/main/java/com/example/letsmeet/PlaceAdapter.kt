package com.example.letsmeet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.letsmeet.databinding.AdapterPlacesBinding

class PlaceAdapter : RecyclerView.Adapter<PlacesViewHolder>()
{
    var places = mutableListOf<Place>()

    fun setPlacesList(places: List<Place>)
    {
        this.places = places.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacesViewHolder
    {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterPlacesBinding.inflate(inflater, parent, false)
        return PlacesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlacesViewHolder, position: Int)
    {
        val place = places[position]
        holder.binding.eventTitle.text = place.name
//        Glide.with(holder.itemView.context).load(place.image).into(holder.binding.imageview)
    }

    override fun getItemCount(): Int
    {
        return places.size
    }

}

class PlacesViewHolder(val binding: AdapterPlacesBinding) : RecyclerView.ViewHolder(binding.root)
{

}
