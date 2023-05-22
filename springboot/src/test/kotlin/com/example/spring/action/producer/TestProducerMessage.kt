package com.example.spring.action.producer

import com.example.kotlinkafka.core.exception.NoSendDataException
import com.example.kotlinkafka.domain.MessageProducer
import com.example.kotlinkafka.dto.MessageDTO
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.kafka.test.context.EmbeddedKafka
import org.springframework.test.annotation.DirtiesContext

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(
    partitions = 1,
    brokerProperties = ["listeners=PLAINTEXT://localhost:9092", "port=9092"]
)

internal class TestProducerMessage {

    @Autowired
    private var messageProducer: MessageProducer? = null

    @Test
    fun `카프케이서 메세지 넘기는 메소드 테스트 케이스`() {
        val dto = MessageDTO("test100")
        val data = messageProducer?.save(dto)
        Assertions.assertEquals(dto.getName(), data?.getName())
    }

    @Test
    fun `카프카에서 메세지를 null 로 던지는 케이스`() {
        Assertions.assertThrows(
            NoSendDataException::class.java,
            Executable {
                messageProducer?.save(null)
            }
        )
    }
}
