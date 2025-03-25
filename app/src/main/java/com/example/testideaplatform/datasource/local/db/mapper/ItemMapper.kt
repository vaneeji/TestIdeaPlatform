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
        append('[')

        forEach { tag ->
            append("\"$tag\", ")
        }
        removeSuffix(", ")

        append(']')
    }.toString()

private fun String.tagsToDomain(): List<String> {
    val stringWithoutBrackets = removePrefix("[").removeSuffix("]")

    val tags = stringWithoutBrackets.filter { it != '"' }.split(", ")

    return tags
}