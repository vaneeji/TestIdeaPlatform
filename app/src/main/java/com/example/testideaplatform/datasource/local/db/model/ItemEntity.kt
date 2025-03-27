package com.example.testideaplatform.datasource.local.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testideaplatform.datasource.local.db.defaults.TestIdeaPlatformDbDefaults.ITEMS_ENTITY_TABLE_NAME
import com.example.testideaplatform.datasource.local.db.defaults.TestIdeaPlatformDbDefaults.Item.ITEM_AMOUNT
import com.example.testideaplatform.datasource.local.db.defaults.TestIdeaPlatformDbDefaults.Item.ITEM_NAME
import com.example.testideaplatform.datasource.local.db.defaults.TestIdeaPlatformDbDefaults.Item.ITEM_TAGS
import com.example.testideaplatform.datasource.local.db.defaults.TestIdeaPlatformDbDefaults.Item.ITEM_TIME

@Entity(tableName = ITEMS_ENTITY_TABLE_NAME)
data class ItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = ITEM_NAME)
    val name: String,

    @ColumnInfo(name = ITEM_TIME)
    val time: Long,

    @ColumnInfo(name = ITEM_TAGS)
    val tags: String,

    @ColumnInfo(name = ITEM_AMOUNT)
    val amount: Int
)