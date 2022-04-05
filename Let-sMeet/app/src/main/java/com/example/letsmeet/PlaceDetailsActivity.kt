package com.example.letsmeet

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.letsmeet.placeRecyclerView.PlaceViewHolder
import android.text.Html

import android.text.Spanned
import androidx.annotation.RequiresApi


class PlaceDetailsActivity : AppCompatActivity()
{
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_details)

        val img : ImageView = findViewById(R.id.event_details_img)
        val title : TextView = findViewById(R.id.event_details_title)
        val description : TextView = findViewById(R.id.event_details_description)

        val place: Place = intent.getSerializableExtra(PlaceViewHolder.PLACE_KEY) as Place

        if (place != null)
        {
            title.text = Html.fromHtml(place.name, Html.FROM_HTML_MODE_COMPACT)
            description.text = Html.fromHtml(place.description, Html.FROM_HTML_MODE_COMPACT)

            var imagesURL : ArrayList<String>? = place.getImages()

            if ( imagesURL != null && imagesURL.isNotEmpty() )
            {
                Glide.with(this)
                    .load(imagesURL[0])
                    .into(img)
            }
        }


    }
}