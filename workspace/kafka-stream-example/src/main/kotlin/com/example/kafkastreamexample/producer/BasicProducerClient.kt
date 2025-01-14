package com.example.kafkastreamexample.producer

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.stereotype.Component

private val log = KotlinLogging.logger {}

@Component
class BasicProducerClient(
    private val streamBridge: StreamBridge
) {

    private val testGroup = "TEST-1"

    private var count = 0

    fun send() {
        log.info { "work send topic - start" }
        streamBridge.send(
            "basicProducer-out-0",
            "$testGroup-${count++}"
        )
        log.info { "work send topic - end" }
    }
}
