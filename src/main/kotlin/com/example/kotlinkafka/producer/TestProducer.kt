package com.example.kotlinkafka.producer

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class TestProducer constructor(
    private val kafkaTemplate: KafkaTemplate<String, String>,
) {
    private val testTopic: String = "testTopic"

    fun save(dto: TestDTO) {

        val objectMapper = ObjectMapper()

        var realString = ""

        try {
            realString = objectMapper.writeValueAsString(dto)
        } catch (e: JsonProcessingException) {
            e.printStackTrace()
        }

        kafkaTemplate.send(testTopic, realString)
    }







}
