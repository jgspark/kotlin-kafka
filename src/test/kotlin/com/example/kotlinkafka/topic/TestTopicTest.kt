package com.example.kotlinkafka.topic

import com.example.kotlinkafka.action.consumer.TestConsumer
import com.example.kotlinkafka.action.producer.TestProducer
import com.example.kotlinkafka.action.producer.dto.TestDTO
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
internal class TestTopicTest {

    @Autowired
    private var testConsumer: TestConsumer? = null

    @Autowired
    private var testProducer: TestProducer? = null

    @Test
    fun `testTopic 에 message 보내기`() {

        val dto = TestDTO("test100")

        testProducer?.save(dto)

        testConsumer?.getLatch()?.await(10000, TimeUnit.MILLISECONDS)

        org.assertj.core.api.Assertions.assertThat(testConsumer?.getLatch()?.count).isEqualTo(1)

//        assertThat(consumer.getLatch().getCount(), equalTo(0L));
//        assertThat(consumer.getPayload(), containsString("embedded-test-topic"));
    }
}
