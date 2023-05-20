package com.example.kotlinkafka.dto

data class SendData(
    private var name: String?
) {

    constructor() : this(null) {}

    fun getName() = this.name
}
