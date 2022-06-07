package com.example.kotlinkafka.consumer

import com.example.kotlinkafka.constants.TopicNames.Companion.testKey
import com.example.kotlinkafka.constants.TopicNames.Companion.testTopicName
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component
import java.util.Date
import java.util.concurrent.CountDownLatch

@Component
class TestConsumer {

    private val latch: CountDownLatch = CountDownLatch(1)

    private var payload: String? = null

    @KafkaListener(
        id = testKey,
        topics = [testTopicName]
    )
    // version 2.5 이상 부터 ConsumerRecordMetadata 객체를 통해서 meta 데이터 추출이 가능
    fun testMessageConsumer(
        @Payload message: String,
        @Header(name = KafkaHeaders.RECEIVED_MESSAGE_KEY, required = false) key: String,
        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) partition: Int,
        @Header(KafkaHeaders.RECEIVED_TOPIC) topic: String,
        // time 의 경우 long type 과 date type 둘다 사용가능하다.
        @Header(KafkaHeaders.RECEIVED_TIMESTAMP) time: Date
    ) {
        payload = message
        println("payload : ${message} \n key : ${key} \n partition : ${partition} \n topic : ${topic} \n time : ${time}")
        latch.countDown()
    }

    fun getLatch() = this.latch

    fun getPayload() = this.payload
}
