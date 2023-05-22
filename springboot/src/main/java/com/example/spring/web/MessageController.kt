package com.example.spring.web

import com.example.spring.domain.MessageProducer
import com.example.spring.dto.MessageDTO
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
