package com.example.spring.infra.serializer

import com.example.spring.core.exception.NoSendDataException
import com.example.spring.dto.SendData
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Serializer

class SendDataSerializer : Serializer<SendData> {

    private val objectMapper = ObjectMapper()

    // 직렬화
    override fun serialize(topic: String?, data: SendData?): ByteArray = data?.let {
        checkNotNull(it.getName()) {
            throw NoSendDataException()
        }
        it
    }.run {
        objectMapper.writeValueAsString(this).toByteArray()
    }
}
