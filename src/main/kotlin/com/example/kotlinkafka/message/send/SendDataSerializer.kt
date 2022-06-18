package com.example.kotlinkafka.message.send

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.errors.SerializationException
import org.apache.kafka.common.serialization.Serializer

class SendDataSerializer : Serializer<SendData> {

    private val objectMapper = ObjectMapper()

    // 직렬화
    override fun serialize(topic: String?, data: SendData?): ByteArray {
        try {
            return objectMapper.writeValueAsString(data).toByteArray()
        } catch (e: Exception) {
            throw SerializationException("change to byteArray error")
        }
    }

}
