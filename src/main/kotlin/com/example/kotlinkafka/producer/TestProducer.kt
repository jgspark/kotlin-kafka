package com.example.kotlinkafka.producer

import com.example.kotlinkafka.config.Sender
import com.example.kotlinkafka.constants.TopicNames.Companion.testKey
import com.example.kotlinkafka.producer.dto.TestDTO
import com.example.kotlinkafka.message.send.SendData
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.stereotype.Component
import org.springframework.util.concurrent.FailureCallback
import org.springframework.util.concurrent.SuccessCallback

@Component
class TestProducer constructor(
    private val sender: Sender,
    private val testTopic: NewTopic
) {
    fun save(dto: TestDTO?): TestDTO? {

        val sendData = SendData(dto?.getName())

        val listenableFuture = sender.send(testTopic.name(), testKey, sendData)

        listenableFuture.addCallback(
            // 성공
            SuccessCallback { result ->
                println("result=> $result")
            },
            // 실패
            FailureCallback { ex ->
                {
                    ex.printStackTrace()
                    ex
                }
            }
        )

        return dto
    }
}
