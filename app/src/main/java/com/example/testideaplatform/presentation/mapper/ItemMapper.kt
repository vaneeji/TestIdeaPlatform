package com.example.testideaplatform.presentation.mapper

import com.example.testideaplatform.domain.model.Item
import com.example.testideaplatform.presentation.model.ItemViewData

fun ItemViewData.toDomain(): Item = Item(
    id = id,
    name = name,
    time = time,
    tags = tags,
    amount = amount
)

fun Item.toViewData(): ItemViewData = ItemViewData(
    id = id,
    name = name,
    time = time,
    tags = tags,
    amount = amount
)