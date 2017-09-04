package com.github.snowparrot.paaarweather

import java.io.*
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by snowparrot on 04.09.17.
 */
class WeatherHttpClient {
    fun getWeatherData(location: webLocation): String? {

        try
        {
            var con: HttpURLConnection = (URL(BASE_URL + location.getWeblocation())).openConnection() as HttpURLConnection
            con.setRequestMethod("GET")
            con.setDoInput(true)
            con.setDoOutput(true)
            con.connect()
            // Let's read the response
            val buffer = StringBuffer()
            var InS = con.getInputStream()
            val br = BufferedReader(InputStreamReader(InS))
            var line:String?
            line = br.readLine()
            while (line != null) {
                buffer.append(line + "rn")
                line = br.readLine()
            }
            InS.close()
            con.disconnect()
            return buffer.toString()
        }
        catch (t:Throwable) {
            t.printStackTrace()
        }
        finally
        {
            return null
        }

    }
    fun getImage(code:String):ByteArray? {
        try
        {
            val con = (URL(IMG_URL + code)).openConnection() as HttpURLConnection
            con.setRequestMethod("GET")
            con.setDoInput(true)
            con.setDoOutput(true)
            con.connect()
            // Let's read the response
            var InS = con.getInputStream()
            val buffer = ByteArray(1024)
            val baos = ByteArrayOutputStream()
            while (InS.read(buffer) != -1) {
                baos.write(buffer)
            }
            return baos.toByteArray()
        }
        catch (t:Throwable) {
            t.printStackTrace()
        }
        finally
        {
            return null
        }
    }
    companion object {
        private val BASE_URL = "http://api.openweathermap.org/data/2.5/weather?"
        private val IMG_URL = "http://openweathermap.org/img/w/"
    }
}