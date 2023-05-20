package com.example.kotlinkafka.config

import com.example.kotlinkafka.infra.config.KafkaProperty
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestPropertySource

@SpringBootTest
@AutoConfigureDataJpa
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@EnableConfigurationProperties(KafkaProperty::class)
@TestPropertySource("classpath:application.yml")
internal class KafkaPropertyTest {

    @Autowired
    private var property: KafkaProperty? = null

    @Test
    fun `설정 파일 테스트 케이스`() {
        Assertions.assertEquals(property?.getFullIp(), "localhost:9092")
        Assertions.assertEquals(property?.getGroupId(), "groupOne")
    }
}
