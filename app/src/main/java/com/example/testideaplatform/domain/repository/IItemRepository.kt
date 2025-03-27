package com.example.testideaplatform.domain.repository

import com.example.testideaplatform.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface IItemRepository {
    suspend fun getAllItems(): List<Item>

    fun getAllItemsFlow(): Flow<List<Item>>

    suspend fun setNewItem(item: Item)

    suspend fun deleteItem(id: Int)

    suspend fun updateItem(item: Item)
}