package com.example.kotlinkafka.utils

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper

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
