package com.example.spring.domain

import com.example.spring.infra.topic.TopicNames.Companion.testKey
import com.example.spring.infra.topic.TopicNames.Companion.testTopicName
import com.example.spring.core.util.convertOf
import com.example.spring.dto.SendData
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Component
import java.util.concurrent.CountDownLatch

@Component
class MessageConsumer {

    private val latch: CountDownLatch = CountDownLatch(1)

    private var payload: SendData? = null

    @KafkaListener(
        id = testKey,
        topics = [testTopicName]
    )
    fun testMessageConsumer(
        message: SendData,
        @Header(name = KafkaHeaders.KEY, required = false) key: String,
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
