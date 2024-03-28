package com.dev.firstapp.data

data class PostResponseModel(
    val `data`: Data,
    val result_code: Int,
    val status: String
)