package com.example.kotlinkafka.consumer

import com.example.kotlinkafka.producer.TestProducer
import com.example.kotlinkafka.producer.dto.TestDTO
import com.example.kotlinkafka.utils.convertOf
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
internal class TestConsumerTest {

    @Autowired
    private var testConsumer: TestConsumer? = null

    @Autowired
    private var testProducer: TestProducer? = null

    private var mock: TestDTO? = null

    @BeforeEach
    fun init() {
        mock = TestDTO("test100")
        testProducer?.save(mock!!)
    }

    @Test
    fun `컨슈머에서 메세지가 도칙했는지 확인`() {

        val latch = testConsumer?.getLatch()

        val mockString = convertOf(mock)

        latch?.await(10000, TimeUnit.MILLISECONDS)

        org.junit.jupiter.api.Assertions.assertEquals(latch?.count, 0)
        org.junit.jupiter.api.Assertions.assertEquals(testConsumer?.getPayload(), mockString)
    }
}
