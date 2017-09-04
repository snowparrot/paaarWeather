package com.github.snowparrot.paaarweather

/**
 * implementier WebLocation fuer Eingaben
 */


class inputLocation (location: String): webLocation {
    val location: String?

    init {
        this.location = location
    }

    override fun getWeblocation(): String {
        return("q=" + location)
    }
}