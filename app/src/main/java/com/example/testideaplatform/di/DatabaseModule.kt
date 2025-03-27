package com.example.testideaplatform.di

import android.content.Context
import androidx.room.Room
import com.example.testideaplatform.datasource.local.db.TestIdeaPlatformDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): TestIdeaPlatformDb =
        Room.databaseBuilder(
            context,
            TestIdeaPlatformDb::class.java,
            TestIdeaPlatformDb.NAME
        )
            .createFromAsset("database/data.db")
            .build()
}