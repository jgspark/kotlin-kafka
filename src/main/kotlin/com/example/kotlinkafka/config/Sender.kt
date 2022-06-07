package com.example.kotlinkafka.config

import org.springframework.kafka.core.KafkaTemplate

class Sender constructor(
    private var kafkaTemplate: KafkaTemplate<String, String>
) {

    fun send(topic: String, id: String, data: String?) {
        kafkaTemplate.send(topic, id, data)
    }

    fun send(topic: String, data: String?) {
        kafkaTemplate.send(topic, data)
    }

}
