package com.example.kotlinkafka.producer

import com.example.kotlinkafka.config.Sender
import com.example.kotlinkafka.producer.dto.TestDTO
import com.example.kotlinkafka.utils.convertOf
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.stereotype.Component

@Component
class TestProducer constructor(
    private val sender: Sender,
    private val testTopic: NewTopic
) {
    fun save(dto: TestDTO): TestDTO {
        val dataString = convertOf(dto)
        sender.send(testTopic.name(), dataString)
        return dto
    }
}
