package com.github.snowparrot.paaarweather

/**
 * implementier WebLocation fuer Eingaben
 */


class inputLocation (location: String): webLocation {
    val _location: String = location

    override fun getWeblocation(): String {
        return("q=" + _location)
    }
}