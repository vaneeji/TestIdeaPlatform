package com.example.testideaplatform.presentation.model

data class ItemViewData(
    val id: Int = 0,

    val name: String,

    val time: Long,

    val tags: List<String>,

    val amount: Int
)