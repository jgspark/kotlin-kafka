package com.excample.legacy.app

import com.excample.legacy.app.dto.MessageDTO
import com.excample.legacy.app.dto.SendData
import org.springframework.stereotype.Component

@Component
class MessageProducer(
//    private val sender: Sender,
//    private val testTopic: NewTopic
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
