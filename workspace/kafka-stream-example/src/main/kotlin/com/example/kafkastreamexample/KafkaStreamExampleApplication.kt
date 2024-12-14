package com.example.kafkastreamexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class KafkaStreamExampleApplication

fun main(args: Array<String>) {
    runApplication<KafkaStreamExampleApplication>(*args)
}
