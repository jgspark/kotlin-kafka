package com.example.spring.core.util

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import java.util.*

/**
 * Any Data Change to String Data
 */
fun convertOf(any: Any?): String? {
    val objectMapper = ObjectMapper()
    var string: String? = null
    try {
        string = objectMapper.writeValueAsString(any)
    } catch (e: JsonProcessingException) {
        e.printStackTrace()
    }
    return string
}

/**
 * long value change to date value
 */
fun convertOf(long: Long) = Date(long * 1000)
