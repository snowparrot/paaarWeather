package com.github.snowparrot.paaarweather.symbols

/**
 * Created by snowparrot on 07.09.17.
 */
enum class weatherIcons {
    DAY_SUN, DAY_CLOUDANDSUN, DAY_CLOUD, DAY_DARKCLOUDS,
    DAY_RAIN, DAY_RAINANDSUN, DAY_THUNDER, DAY_SNOW, DAY_MIST,
    NIGHT_MOON, NIGHT_CLOUDANDMOON, NIGHT_CLOUD, NIGHT_DARKCLOUDS, NIGHT_RAIN,
    NIGHT_RAINANDMOON, NIGHT_THUNDER, NIGHT_SNOW, NIGHT_MIST
}

public fun parseStringToWeatherIcons(response : String) : weatherIcons {
    var e = Exception("parseError")
    when (response) {
        "01d" -> return weatherIcons.DAY_SUN
        "02d" -> return weatherIcons.DAY_CLOUDANDSUN
        "03d" -> return weatherIcons.DAY_CLOUD
        "04d" -> return weatherIcons.DAY_DARKCLOUDS
        "09d" -> return weatherIcons.DAY_RAIN
        "10d" -> return weatherIcons.DAY_RAINANDSUN
        "11d" -> return weatherIcons.DAY_THUNDER
        "13d" -> return weatherIcons.DAY_SNOW
        "50d" -> return weatherIcons.DAY_MIST
        "01n" -> return weatherIcons.NIGHT_MOON
        "02n" -> return weatherIcons.NIGHT_CLOUDANDMOON
        "03n" -> return weatherIcons.NIGHT_CLOUD
        "04n" -> return weatherIcons.NIGHT_DARKCLOUDS
        "09n" -> return weatherIcons.NIGHT_RAIN
        "10n" -> return weatherIcons.NIGHT_RAINANDMOON
        "11n" -> return weatherIcons.NIGHT_THUNDER
        "13n" -> return weatherIcons.NIGHT_SNOW
        "50n" -> return weatherIcons.NIGHT_MIST
        else -> throw e
    }
}