package com.example.kafkastreampushsample.scheduler

import com.example.kafkastreampushsample.producer.BasicProducerClient
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

private val log = KotlinLogging.logger {}

@Component
class KafkaAutoPushScheduler(
    private val basicProducerClient: BasicProducerClient
) {

    // 1 초 마다 실행을 한다.
    @Scheduled(cron = "0/1 * * * * ?")
    fun sendMessage() {
        log.info { "Work Send Scheduler" }
        basicProducerClient.send()
    }
}
