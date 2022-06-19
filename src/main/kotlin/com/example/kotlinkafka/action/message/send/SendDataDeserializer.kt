package com.example.kotlinkafka.action.message.send

import com.example.kotlinkafka.config.exception.NoSendDataException
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Deserializer
import java.nio.charset.StandardCharsets.UTF_8

class SendDataDeserializer : Deserializer<SendData> {

    private val objectMapper = ObjectMapper()

    // 역직렬화
    override fun deserialize(topic: String?, data: ByteArray?): SendData =
        data?.let {
            if (null == it) throw NoSendDataException()
            it
        }.run {
            objectMapper.readValue(String(this!!, UTF_8), SendData::class.java)
        }

}
