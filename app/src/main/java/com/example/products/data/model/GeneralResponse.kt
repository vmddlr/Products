package com.example.products.data.model

data class GeneralResponse<T>(
    val entity: T? = null,
    val messageError: String = ""
)