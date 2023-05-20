package com.example.kotlinkafka.infra.config

import com.example.kotlinkafka.infra.topic.TopicNames.Companion.testTopicName
import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder
import org.springframework.kafka.core.KafkaAdmin

@Configuration
class TopicConfiguration constructor(
    private val kafkaProperty: KafkaProperty
) {

    @Bean
    fun admin() = KafkaAdmin(mapOf(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaProperty.getFullIp()))

    @Bean
    fun testTopic(): NewTopic = TopicBuilder
        .name(testTopicName)
        .partitions(1)
        .replicas(1)
        .build()
}
