package com.example.kotlinkafka.web

import com.example.kotlinkafka.dto.MessageDTO
import com.example.kotlinkafka.domain.MessageProducer
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController(private val messageProducer: MessageProducer) {

    @PostMapping("send")
    @ResponseStatus(HttpStatus.CREATED)
    fun testMethod(@RequestBody dto: MessageDTO): MessageDTO = messageProducer.save(dto)
}
