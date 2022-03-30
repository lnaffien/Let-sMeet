package com.example.thermotector

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtTemperature : TextView = findViewById(R.id.txt_temp_actuelle)
        txtTemperature.text = "23"
    }
}