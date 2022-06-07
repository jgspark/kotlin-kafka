package com.example.kotlinkafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class KotlinKafkaApplication

fun main(args: Array<String>) {
    runApplication<KotlinKafkaApplication>(*args)
}
