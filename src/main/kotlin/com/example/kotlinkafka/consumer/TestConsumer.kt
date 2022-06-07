package com.example.kotlinkafka.consumer

import com.example.kotlinkafka.constants.TopicNames.Companion.testTopicName
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.util.concurrent.CountDownLatch

@Component
class TestConsumer {

    private val latch: CountDownLatch = CountDownLatch(1)

    private var payload: String? = null

    @KafkaListener(topics = [testTopicName])
    fun testMessageConsumer(message: String) {
        payload = message
        println(message)
        latch.countDown()
    }

    fun getLatch() = this.latch

    fun getPayload() = this.payload
}
