package com.example.testideaplatform.datasource.local.db.mapper

import com.example.testideaplatform.datasource.local.db.model.ItemEntity
import com.example.testideaplatform.domain.model.Item

fun Item.toEntity(): ItemEntity = ItemEntity(
    id = id,
    name = name,
    time = time,
    tags = tags.tagsToEntity(),
    amount = amount
)

fun ItemEntity.toDomain(): Item = Item(
    id = id,
    name = name,
    time = time,
    tags = tags.tagsToDomain(),
    amount = amount
)

private fun List<String>.tagsToEntity(): String =
    StringBuilder().apply {
        this@tagsToEntity.forEach { tag ->
            append("$tag,")
        }
    }.toString()

private fun String.tagsToDomain(): List<String> {
    val copy = this
    val formattedString = copy.run {
        this@run.replace("[", "")
            .replace("]", "")
            .replace("\"", "")
    }

    val tags = formattedString.split(",")

    return tags
}