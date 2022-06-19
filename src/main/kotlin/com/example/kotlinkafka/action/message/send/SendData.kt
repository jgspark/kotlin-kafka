package com.example.kotlinkafka.action.message.send

data class SendData(
    private var name: String?
) {

    constructor() : this(null) {}

    fun getName() = this.name
}
