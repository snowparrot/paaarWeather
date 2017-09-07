package com.github.snowparrot.paaarweather

/**
 * Created by snowparrot on 22.08.17.
 */


import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class WeatherView : Activity() {

    lateinit var location : String
    lateinit var temperature: String

    lateinit var textLocation: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(16974382) // Theme_Material_NoActionBar
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weatherview)

        textLocation = findViewById(R.id.textLocation)
        var b = intent
        location = b.getStringExtra("location")
        temperature = b.getStringExtra("temperature")

        textLocation.setText(location)





    }
}
