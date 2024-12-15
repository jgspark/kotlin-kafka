package com.example.kafkastreamexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaStreamExampleApplication

fun main(args: Array<String>) {
    runApplication<KafkaStreamExampleApplication>(*args)
}
