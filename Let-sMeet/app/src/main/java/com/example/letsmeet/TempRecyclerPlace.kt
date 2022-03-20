package com.example.letsmeet

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TempRecyclerPlace ( private val places: ArrayList<String> ) : RecyclerView.Adapter<TempRecyclerPlace.TempPlaceHolder>()
{
    override fun getItemCount() = places.size

    override fun onBindViewHolder(holder: TempRecyclerPlace.TempPlaceHolder, position: Int)
    {
        val itemPlace = places[position]
        holder.bindPlace(itemPlace)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TempRecyclerPlace.TempPlaceHolder
    {
        val inflatedView = parent.inflate(R.layout.adapter_places, false)
        return TempPlaceHolder(inflatedView)
    }


    class TempPlaceHolder (v : View) : RecyclerView.ViewHolder(v), View.OnClickListener
    {
        private var view : View = v
        private var place : String ? = null

        init
        {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            Log.e("RecyclerView", "View clicked")
            val context = itemView.context
            val showPlaceIntent = Intent(context, PlaceDetailsActivity::class.java)
            showPlaceIntent.putExtra(PLACE_KEY, place)
            context.startActivity(showPlaceIntent)

        }

        companion object {
            private val PLACE_KEY = "PLACE"
        }

        fun bindPlace(place : String)
        {
//            this.photo = photo
//            Picasso.with(view.context).load(photo.url).into(view.itemImage)
            var title : TextView = view.findViewById(R.id.event_title)
            title.text = place
        }
    }
}

