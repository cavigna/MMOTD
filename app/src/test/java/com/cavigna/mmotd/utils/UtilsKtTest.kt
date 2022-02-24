package com.cavigna.mmotd.utils

import android.util.Log
import org.junit.Assert.*

import org.junit.Test

class UtilsKtTest {

    @Test
    fun parseDateGameTest() {
        val input = "2011-04-12"
        val resultado = parseDateGame(input)
        val output = "12 Apr 2011"

        assertEquals(output, resultado)

    }
}