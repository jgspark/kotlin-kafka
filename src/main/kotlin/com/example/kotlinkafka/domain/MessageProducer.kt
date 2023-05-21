package com.example.kotlinkafka.domain

import com.example.kotlinkafka.infra.config.Sender
import com.example.kotlinkafka.dto.MessageDTO
import com.example.kotlinkafka.dto.SendData
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
