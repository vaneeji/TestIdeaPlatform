package com.example.testideaplatform.domain.model

data class Item(
    val id: Int = 0,

    val name: String,

    val time: Long,

    val tags: List<String>,

    val amount: Int
)
