package com.example.kotlinkafka.producer

import com.example.kotlinkafka.producer.dto.TestDTO
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
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
}
