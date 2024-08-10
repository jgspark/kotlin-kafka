package com.excample.legacy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class LegacyApplication

fun main(args: Array<String>) {
    runApplication<LegacyApplication>(*args)
}
