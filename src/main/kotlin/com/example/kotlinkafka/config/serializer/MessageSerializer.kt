package com.example.kotlinkafka.config.serializer

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serializer

data class Message(
    val name: String?
)

class MessageSerializer : Serializer<Message>, Deserializer<Message> {

    private val objectMapper = ObjectMapper()

    // 직렬화
    override fun serialize(topic: String?, data: Message?): ByteArray = data.let {
        objectMapper.writeValueAsBytes(data)
    } ?: kotlin.run {
        throw NullPointerException()
    }

    // 역직렬화
    override fun deserialize(topic: String?, data: ByteArray?): Message = data.let {
        objectMapper.readValue(data as String)
    } ?: kotlin.run {
        throw NullPointerException()
    }

    override fun close() {
        TODO("Not yet implemented")
    }

    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {
        TODO("Not yet implemented")
    }
}
