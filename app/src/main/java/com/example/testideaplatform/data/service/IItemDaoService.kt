package com.example.testideaplatform.data.service

import com.example.testideaplatform.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface IItemDaoService {
    suspend fun getAllItems(): List<Item>

    fun getAllItemsFlow(): Flow<List<Item>>

    suspend fun setNewItem(item: Item)

    suspend fun deleteItem(id: Int)

    suspend fun updateItem(item: Item)
}