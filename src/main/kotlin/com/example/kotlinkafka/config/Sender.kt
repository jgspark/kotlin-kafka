package com.example.kotlinkafka.config

import com.example.kotlinkafka.action.message.send.SendData
import org.springframework.kafka.core.KafkaTemplate

class Sender constructor(
    private var kafkaTemplate: KafkaTemplate<String, Any>
) {

    fun send(topic: String, id: String, sendData: SendData?) = kafkaTemplate.send(topic, id, sendData)

    fun send(topic: String, sendData: SendData?) = kafkaTemplate.send(topic, sendData)
}
