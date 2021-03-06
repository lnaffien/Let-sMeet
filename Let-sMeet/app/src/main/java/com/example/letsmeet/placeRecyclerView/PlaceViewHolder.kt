package com.example.letsmeet.placeRecyclerView

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.letsmeet.Place
import com.example.letsmeet.PlaceDetailsActivity
import com.example.letsmeet.R

class PlaceViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
    private var view: View = view
    private lateinit var place: Place

    init {
        view.setOnClickListener(this)
    }

    override fun onClick(v: View?)
    {
        Log.e("RecyclerView", "View clicked")
        val context = itemView.context
        val showPlaceIntent = Intent(context, PlaceDetailsActivity::class.java)
        showPlaceIntent.putExtra(PLACE_KEY, place)
        context.startActivity(showPlaceIntent)
    }

    companion object {
        const val PLACE_KEY = "PLACE"
    }

    fun bindPlace(place: Place)
    {
        this.place = place
//            this.photo = photo
//            Picasso.with(view.context).load(photo.url).into(view.itemImage)
        var name: TextView = view.findViewById(R.id.event_title)
        name.text = place.name

        var img : ImageView = view.findViewById(R.id.event_img)
        var imagesURL : ArrayList<String>? = place.getImages()
        if ( imagesURL != null && imagesURL.isNotEmpty() )
        {
            Glide.with(view)
                .load(imagesURL[0])
                .into(img)
        }
        else
        {
            img.setImageResource(R.drawable.ic_sharp_image_24)
        }

    }
}