package com.example.kotlinkafka.consumer

import com.example.kotlinkafka.constants.TopicNames.Companion.testKey
import com.example.kotlinkafka.constants.TopicNames.Companion.testTopicName
import com.example.kotlinkafka.message.send.SendData
import com.example.kotlinkafka.utils.convertOf
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Component
import java.util.concurrent.CountDownLatch

@Component
class TestConsumer {

    private val latch: CountDownLatch = CountDownLatch(1)

    private var payload: SendData? = null

    @KafkaListener(
        id = testKey,
        topics = [testTopicName]
    )
    fun testMessageConsumer(
        message: SendData,
        @Header(name = KafkaHeaders.RECEIVED_MESSAGE_KEY, required = false) key: String,
        consumerRecordMetadata: ConsumerRecordMetadata
    ) {
        payload = message

        val partition = consumerRecordMetadata.partition()

        val topic = consumerRecordMetadata.topic()

        val time = convertOf(consumerRecordMetadata.timestamp())

        println("payload : ${message.getName()} \n key : $key \n partition : $partition \n topic : $topic \n time : $time")

        latch.countDown()
    }

    fun getLatch() = this.latch

    fun getPayload() = this.payload
}
