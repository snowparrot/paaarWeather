package com.github.snowparrot.paaarweather

/**
 * Created by snowparrot on 22.08.17.
 */


import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class WeatherView : Activity() {

    lateinit var location : String

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(16974382) // Theme_Material_NoActionBar
        super.onCreate(savedInstanceState)

        var b = intent
        location = b.getStringExtra("location")


        setContentView(R.layout.weatherview)
    }
}
