package com.example.kotlinkafka.service.producer.dto

data class TestDTO constructor(private var name: String) {

    fun setName(name: String) {
        this.name = name
    }

    fun getName() = this.name
}
