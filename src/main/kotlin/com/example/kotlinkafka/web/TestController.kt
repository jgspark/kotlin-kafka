package com.example.kotlinkafka.web

import com.example.kotlinkafka.service.producer.TestDTO
import com.example.kotlinkafka.service.producer.TestProducer
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController constructor(private val testProducer: TestProducer) {

    @PostMapping("test")
    fun testMethod(dto: TestDTO) {
        testProducer.save(dto)
    }
}
