package com.example.kotlinkafka.action.message.send

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.errors.SerializationException
import org.apache.kafka.common.serialization.Deserializer
import java.nio.charset.StandardCharsets.UTF_8

class SendDataDeserializer : Deserializer<SendData> {

    private val objectMapper = ObjectMapper()

    // 역직렬화
    override fun deserialize(topic: String?, data: ByteArray?): SendData {
        return objectMapper.readValue(
            String(
                data ?: throw SerializationException("Error when deserializing byte[] to Product"), UTF_8
            ), SendData::class.java
        )
    }
}
