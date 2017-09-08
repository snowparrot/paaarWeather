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
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : Activity() {


    //TODO: Spinner hinzufügen
    private val BASE_URL = "http://api.openweathermap.org/data/2.5/weather?units=metric&&appid=b7359d3782b564e9f9460edf76587eee&lang=de&"

    private lateinit var button_search : Button
    private lateinit var editText_search : EditText

    private lateinit var queue : RequestQueue



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_search = findViewById(R.id.button_search)
        editText_search = findViewById(R.id.editText_search)
        editText_search.setText(R.string.enter_location)

        queue = Volley.newRequestQueue(this)
        button_search.setOnClickListener{

            val url = BASE_URL + inputLocation(editText_search.text.toString()).getWeblocation()

            val toast = Toast.makeText(this, R.string.error_internet, Toast.LENGTH_LONG)
            val i  = Intent(this, WeatherView::class.java)
            var JsonReqeust = JsonObjectRequest(Request.Method.GET, url, null,
                    object: Response.Listener<JSONObject> {
                        override fun onResponse(response: JSONObject?) {
                            if (response == null) {
                                toast.show()
                                return
                            }
                            else {
                                var location = response.get("name")
                                var temperature = (response.get("main") as JSONObject).get("temp")

                                var JArray = response.getJSONArray("weather")[0] as JSONObject
                                var symbol = JArray.get("icon")

                                var bundle = Bundle()
                                bundle.putString("location", location.toString())
                                bundle.putString("temperature", temperature.toString())
                                bundle.putString("symbol", symbol.toString())
                                i.putExtras(bundle)
                                startActivity(i)
                            }
                        }
                    },
                    object : Response.ErrorListener {
                        public override fun onErrorResponse(error: VolleyError?) {
                            toast.show()
                            kotlin.error(error.toString())

                        }
                    })
            queue.add(JsonReqeust)
        }
    editText_search.setOnClickListener({
        if (editText_search.getText().toString() == resources.getString(R.string.enter_location)) {
            editText_search.setText("")
        }
    })
    }
}
