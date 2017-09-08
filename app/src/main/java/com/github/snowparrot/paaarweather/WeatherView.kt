package com.github.snowparrot.paaarweather

/**
 * Created by snowparrot on 22.08.17.
 */


import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.github.snowparrot.paaarweather.symbols.*


class WeatherView : Activity() {

    lateinit var location : String
    lateinit var temperature: String

    lateinit var textLocation: TextView
    lateinit var weatherImage: ImageView
    lateinit var iconWeather: weatherIcons
    lateinit var textTemperature: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(16974382) // Theme_Material_NoActionBar
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weatherview)

        textLocation = findViewById(R.id.textLocation)
        weatherImage = findViewById(R.id.weatherImage)
        textTemperature = findViewById(R.id.textTemperature)

        var b = intent
        location = b.getStringExtra("location")
        temperature = b.getStringExtra("temperature")

        iconWeather = parseStringToWeatherIcons(b.getStringExtra("symbol"))

        textLocation.setText(location)
        weatherImage.setImageResource(getImageByweatherIcon(iconWeather))
        textTemperature.setText(temperature)



    }


    fun getImageByweatherIcon (icon: weatherIcons) : Int {
        when (icon) {
            weatherIcons.DAY_SUN -> return(R.drawable.sonne)
            weatherIcons.DAY_RAIN -> return(R.drawable.regen)
            weatherIcons.NIGHT_RAIN -> return(R.drawable.regen)
            weatherIcons.DAY_MIST -> return(R.drawable.nebel)
            weatherIcons.NIGHT_MIST -> return(R.drawable.nebel)
            else -> return(R.drawable.nebel)
        }
    }
}
