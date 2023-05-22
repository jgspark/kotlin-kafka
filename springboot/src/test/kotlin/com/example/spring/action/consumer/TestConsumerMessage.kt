package com.example.spring.action.consumer

import com.example.kotlinkafka.dto.SendData
import com.example.kotlinkafka.domain.MessageProducer
import com.example.kotlinkafka.domain.MessageConsumer
import com.example.kotlinkafka.dto.MessageDTO
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.kafka.test.context.EmbeddedKafka
import org.springframework.test.annotation.DirtiesContext
import java.util.concurrent.TimeUnit

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(
    partitions = 1,
    brokerProperties = ["listeners=PLAINTEXT://localhost:9092", "port=9092"]
)
internal class TestConsumerMessage {

    @Autowired
    private var messageConsumer: MessageConsumer? = null

    @Autowired
    private var messageProducer: MessageProducer? = null

    private var mock: MessageDTO? = null

    @BeforeEach
    fun init() {
        mock = MessageDTO("test100")
        messageProducer?.save(mock!!)
    }

    @Test
    fun `컨슈머에서 메세지가 도칙했는지 확인`() {

        val latch = messageConsumer?.getLatch()

        val mockSendData = SendData(mock?.getName())

        latch?.await(10000, TimeUnit.MILLISECONDS)

        org.junit.jupiter.api.Assertions.assertEquals(latch?.count, 0)
        org.junit.jupiter.api.Assertions.assertEquals(messageConsumer?.getPayload(), mockSendData)
    }
}
