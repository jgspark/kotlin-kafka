package com.example.kotlinkafka.producer

import com.example.kotlinkafka.constants.TopicNames.Companion.testTopic
import com.example.kotlinkafka.producer.dto.TestDTO
import com.example.kotlinkafka.utils.convertOf
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class TestProducer constructor(
    private val kafkaTemplate: KafkaTemplate<String, String>,
) {

    fun save(dto: TestDTO): TestDTO {
        var dataString = convertOf(dto)
        kafkaTemplate.send(testTopic, dataString)
        return dto
    }
}
