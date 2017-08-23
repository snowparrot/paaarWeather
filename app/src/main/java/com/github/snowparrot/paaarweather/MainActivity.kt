package com.github.snowparrot.paaarweather

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : Activity() {

    private lateinit var button_search : Button
    private lateinit var editText_search : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_search = findViewById(R.id.button_search)
        editText_search = findViewById(R.id.editText_search)

        button_search.setOnClickListener{
            val i  = Intent(this, WeatherView::class.java)
            var location =  editText_search.text ?: ""

            var bundle = Bundle()
            bundle.putString("location", location.toString())
            i.putExtras(bundle)
            startActivity(i)
        }




    }
}
