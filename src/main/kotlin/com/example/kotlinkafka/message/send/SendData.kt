package com.example.kotlinkafka.message.send

//@kotlinx.serialization.Serializable
data class SendData(
    private var name: String?
) {
    fun getName() = this.name
}
