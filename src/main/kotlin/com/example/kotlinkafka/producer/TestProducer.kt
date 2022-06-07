package com.example.kotlinkafka.producer

import com.example.kotlinkafka.config.Sender
import com.example.kotlinkafka.constants.TopicNames.Companion.testKey
import com.example.kotlinkafka.producer.dto.TestDTO
import com.example.kotlinkafka.utils.convertOf
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.stereotype.Component
import org.springframework.util.concurrent.FailureCallback
import org.springframework.util.concurrent.SuccessCallback

@Component
class TestProducer constructor(
    private val sender: Sender,
    private val testTopic: NewTopic
) {
    fun save(dto: TestDTO): TestDTO {
       
        val dataString = convertOf(dto)

        val listenableFuture = sender.send(testTopic.name(), testKey, dataString)

        listenableFuture.addCallback(
            // success
            SuccessCallback { result ->
                println("result=> ${result}")
            },
            // failure
            FailureCallback { ex ->
                {
                    ex.printStackTrace()
                }
            })
        return dto
    }
}
