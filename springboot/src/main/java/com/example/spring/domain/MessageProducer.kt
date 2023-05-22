package com.example.spring.domain

import com.example.spring.dto.MessageDTO
import com.example.spring.dto.SendData
import com.example.spring.infra.config.Sender
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.stereotype.Component

@Component
class MessageProducer constructor(
    private val sender: Sender,
    private val testTopic: NewTopic
) {
    fun save(dto: MessageDTO?): MessageDTO {

        val sendData = SendData(dto?.getName())

//        val listenableFuture = sender.send(testTopic.name(), testKey, sendData)

//        listenableFuture.

//        listenableFuture.
//        listenableFuture.addCallback(
//            // 성공
//            SuccessCallback { result ->
//                println("result=> $result")
//            },
//            // 실패
//            FailureCallback { ex ->
//                {
//                    ex.printStackTrace()
//                    ex
//                }
//            }
//        )

//        return dto
        return MessageDTO("")
    }
}
