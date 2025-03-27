package com.example.testideaplatform.data.repository

import com.example.testideaplatform.data.service.IItemDaoService
import com.example.testideaplatform.datasource.local.db.model.ItemEntity
import com.example.testideaplatform.domain.model.Item
import com.example.testideaplatform.domain.repository.IItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ItemRepository(
    private val itemDaoService: IItemDaoService
) : IItemRepository {
    override suspend fun getAllItems(): List<Item> = itemDaoService.getAllItems()

    override fun getAllItemsFlow(): Flow<List<Item>> = itemDaoService.getAllItemsFlow()

    override suspend fun setNewItem(item: Item) {
        itemDaoService.setNewItem(item)
    }

    override suspend fun deleteItem(id: Int) {
        itemDaoService.deleteItem(id)
    }

    override suspend fun updateItem(item: Item) {
        itemDaoService.updateItem(item)
    }
}