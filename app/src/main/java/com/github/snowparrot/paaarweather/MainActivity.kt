package com.github.snowparrot.paaarweather

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : Activity() {

    private val BASE_URL = "http://api.openweathermap.org/data/2.5/weather?units=metric&&appid=b7359d3782b564e9f9460edf76587eee&"

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

        var request = Volley.newRequestQueue(this)
        var url = BASE_URL + inputLocation(editText_search.text.toString()).getWeblocation()

        var JsonReqeust = JsonObjectRequest(Request.Method.GET, url, null,
                Response.Listener<JSONObject> {

                },
                Response.ErrorListener {
                    var toast = Toast.makeText(this, R.string.error_internet, Toast.LENGTH_LONG)
                    toast.show()
        })

    }
}
