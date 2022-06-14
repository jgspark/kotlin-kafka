package com.example.kotlinkafka.config

import com.example.kotlinkafka.config.serializer.Message
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate

@EnableKafka
@Configuration
class ProducerConfiguration constructor(private val kafkaProperty: KafkaProperty) {

    @Bean
    fun defaultKafkaProducerFactory(): DefaultKafkaProducerFactory<String, Message> {
        return DefaultKafkaProducerFactory<String, Message>(getConfig())
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, Message> = KafkaTemplate(defaultKafkaProducerFactory())

    private fun getConfig(): Map<String, Any> = mapOf(
        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaProperty.getFullIp(),
        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
//        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to MessageSerializer::class.java.canonicalName
    )

    @Bean
    fun sender(
        kafkaTemplate: KafkaTemplate<String, String>
    ): Sender = Sender(kafkaTemplate)
}
