package com.example.testideaplatform.datasource.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testideaplatform.datasource.local.db.model.ItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setItem(item: ItemEntity)

    @Query("select * from item")
    suspend fun getItems(): List<ItemEntity>

    @Query("select * from item")
    fun getItemsFlow(): Flow<List<ItemEntity>>

    @Query("delete from item where id = :id")
    suspend fun deleteItem(id: Int)

    @Query("update item set name = :name, time = :time, tags = :tags, amount = :amount where id = :id ")
    suspend fun updateItem(
        id: Int, name: String,
        time: Long, tags: String, amount: Int
    )
}