package com.example.kotlinkafka.consumer

import com.example.kotlinkafka.constants.TopicNames.Companion.testTopic
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class TestConsumer {

    @KafkaListener(topics = [testTopic])
    fun testMessageConsumer() {
        println("message success")
    }
}
