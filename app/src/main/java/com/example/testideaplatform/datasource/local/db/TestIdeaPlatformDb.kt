package com.example.testideaplatform.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testideaplatform.datasource.local.db.dao.ItemDao
import com.example.testideaplatform.datasource.local.db.model.ItemEntity

@Database(
    entities = [
        ItemEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class TestIdeaPlatformDb() : RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object {
        const val NAME = "testIdeaPlatformDb"
    }
}