package com.excample.legacy.app.dto

data class SendData(
    private var name: String?
) {

    constructor() : this(null) {}

    fun getName() = this.name
}
