package com.example.testideaplatform.datasource.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
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

    @Update
    suspend fun updateItem(item: ItemEntity)
}