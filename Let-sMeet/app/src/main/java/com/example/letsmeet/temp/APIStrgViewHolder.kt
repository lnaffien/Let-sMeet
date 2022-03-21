package com.example.letsmeet.temp

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.letsmeet.Place
import com.example.letsmeet.PlaceDetailsActivity
import com.example.letsmeet.R

class APIStrgViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
    private var view: View = view
    private var place: String? = null

    init {
        view.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Log.e("RecyclerView", "View clicked")
        val context = itemView.context
        val showPlaceIntent = Intent(context, PlaceDetailsActivity::class.java)
        showPlaceIntent.putExtra(PLACE_KEY, place)
        context.startActivity(showPlaceIntent)

    }

    companion object {
        private const val PLACE_KEY = "PLACE"
    }

    fun bindPlace(place: Place)
    {
//            this.photo = photo
//            Picasso.with(view.context).load(photo.url).into(view.itemImage)
        var name: TextView = view.findViewById(R.id.event_title)
        name.text = place.name
    }
}