package com.example.kafkastreamexample.scheduler

import com.example.kafkastreamexample.producer.BasicProducerClient
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

private val log = KotlinLogging.logger {}

@Component
class SendScheduler(
    private val basicProducerClient: BasicProducerClient
) {

    // 10 초 마다 실행을 한다.
    @Scheduled(cron = "0/5 * * * * ?")
    fun sendMessage() {
        log.info { "Work Send Scheduler" }
        basicProducerClient.send()
    }
}
