package com.example.kotlinkafka.action.message.send

import com.example.kotlinkafka.exception.NoSendDataException
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Serializer

class SendDataSerializer : Serializer<SendData> {

    private val objectMapper = ObjectMapper()

    // 직렬화
    override fun serialize(topic: String?, data: SendData?): ByteArray = data?.let {
        if (null == it.getName()) {
            throw NoSendDataException()
        }
    }.run {
        objectMapper.writeValueAsString(data).toByteArray()
    }

}
