package com.example.testideaplatform.di

import com.example.testideaplatform.data.repository.ItemRepository
import com.example.testideaplatform.data.service.IItemDaoService
import com.example.testideaplatform.datasource.local.db.TestIdeaPlatformDb
import com.example.testideaplatform.datasource.local.service.ItemDaoService
import com.example.testideaplatform.domain.repository.IItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class ItemModule {

    @Provides
    fun provideItemDaoService(
        itemDatabase: TestIdeaPlatformDb
    ): IItemDaoService = ItemDaoService(
        itemDatabase = itemDatabase
    )

    @Provides
    fun provideItemRepository(
        itemDaoService: IItemDaoService
    ): IItemRepository = ItemRepository(
        itemDaoService = itemDaoService
    )
}