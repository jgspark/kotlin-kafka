package com.example.kafkastreampushsample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class KafkaStreamPushSampleApplication

fun main(args: Array<String>) {
    runApplication<KafkaStreamPushSampleApplication>(*args)
}
