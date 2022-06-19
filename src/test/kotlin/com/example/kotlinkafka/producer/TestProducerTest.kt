package com.example.kotlinkafka.producer

import com.example.kotlinkafka.action.producer.TestProducer
import com.example.kotlinkafka.exception.NoSendDataException
import com.example.kotlinkafka.action.producer.dto.TestDTO
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

internal class TestProducerTest {

    @Autowired
    private var testProducer: TestProducer? = null

    @Test
    fun `카프케이서 메세지 넘기는 메소드 테스트 케이스`() {
        val dto = TestDTO("test100")
        val data = testProducer?.save(dto)
        Assertions.assertEquals(dto.getName(), data?.getName())
    }

    @Test
    fun `카프카에서 메세지를 null 로 던지는 케이스`() {
        Assertions.assertThrows(NoSendDataException::class.java,
            Executable {
                testProducer?.save(null)
            }
        )
    }
}
