package com.example.testideaplatform.datasource.local.service

import com.example.testideaplatform.data.service.IItemDaoService
import com.example.testideaplatform.datasource.local.db.TestIdeaPlatformDb
import com.example.testideaplatform.datasource.local.db.dao.ItemDao
import com.example.testideaplatform.datasource.local.db.mapper.toDomain
import com.example.testideaplatform.datasource.local.db.mapper.toEntity
import com.example.testideaplatform.datasource.local.db.model.ItemEntity
import com.example.testideaplatform.domain.model.Item
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class ItemDaoService(
    itemDatabase: TestIdeaPlatformDb,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : IItemDaoService {
    private val itemDao: ItemDao = itemDatabase.itemDao()

    override suspend fun getAllItems(): List<Item> =
        withContext(dispatcher) {
            itemDao.getItems().map(ItemEntity::toDomain)
        }

    override fun getAllItemsFlow(): Flow<List<Item>> = itemDao.getItemsFlow()
        .map { items ->
            items.map(ItemEntity::toDomain)
        }.flowOn(dispatcher)

    override suspend fun setNewItem(item: Item) {
        withContext(dispatcher) {
            itemDao.setItem(item.toEntity())
        }
    }

    override suspend fun deleteItem(id: Int) {
        withContext(dispatcher) {
            itemDao.deleteItem(id)
        }
    }

    override suspend fun updateItem(item: Item) {
        withContext(dispatcher) {
            val itemEntity = item.toEntity()

            itemDao.updateItem(
                id = itemEntity.id,
                name = itemEntity.name,
                time = itemEntity.time,
                tags = itemEntity.tags,
                amount = itemEntity.amount
            )
        }
    }
}