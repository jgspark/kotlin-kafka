package com.excample.legacy.infra.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "kafka")
data class KafkaProperty constructor(
    private var id: String,
    private var port: String,
    private var groupId: String,
) {
    fun getFullIp() = "${this.id}:${this.port}"

    fun getGroupId() = this.groupId
}
