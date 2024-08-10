package com.excample.legacy.infra.config

import com.excample.legacy.infra.topic.TopicNames.Companion.TEST_TOPIC_NAME
import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder
import org.springframework.kafka.core.KafkaAdmin

@Configuration
class TopicConfiguration constructor(
    private val kafkaProperty: KafkaProperty,
) {
    @Bean
    fun admin() = KafkaAdmin(mapOf(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaProperty.getFullIp()))

    @Bean
    fun testTopic(): NewTopic =
        TopicBuilder
            .name(TEST_TOPIC_NAME)
            .partitions(1)
            .replicas(1)
            .build()
}
