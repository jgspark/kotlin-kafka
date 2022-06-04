package com.example.kotlinkafka.service.consumer

import com.example.kotlinkafka.constants.TopicNames.Companion.testTopic
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class TestConsumer {

    @KafkaListener(topics = [testTopic])
    fun testMessageConsumer() {
        println("message success")
    }
}
