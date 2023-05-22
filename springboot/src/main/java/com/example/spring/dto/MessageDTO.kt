package com.example.spring.dto

data class MessageDTO constructor(private var name: String) {

    fun setName(name: String) {
        this.name = name
    }

    fun getName() = this.name
}
