package com.example.kotlinkafka.topic

import com.example.kotlinkafka.domain.MessageConsumer
import com.example.kotlinkafka.domain.MessageProducer
import com.example.kotlinkafka.dto.MessageDTO
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
    private var messageConsumer: MessageConsumer? = null

    @Autowired
    private var messageProducer: MessageProducer? = null

    @Test
    fun `testTopic 에 message 보내기`() {

        val dto = MessageDTO("test100")

        messageProducer?.save(dto)

        messageConsumer?.getLatch()?.await(10000, TimeUnit.MILLISECONDS)

        org.assertj.core.api.Assertions.assertThat(messageConsumer?.getLatch()?.count).isEqualTo(1)

//        assertThat(consumer.getLatch().getCount(), equalTo(0L));
//        assertThat(consumer.getPayload(), containsString("embedded-test-topic"));
    }
}
