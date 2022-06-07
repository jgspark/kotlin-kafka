package com.example.kotlinkafka.config

import com.example.kotlinkafka.constants.TopicNames.Companion.testTopicName
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class TopicConfiguration {

    @Bean
    fun testTopic(): NewTopic = TopicBuilder.name(testTopicName).build()
}
