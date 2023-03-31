package com.example.newsapp.di

import android.content.Context
import androidx.room.Room
import com.example.newsapp.room.AppDatabase
import com.example.newsapp.room.DbDao
import com.example.newsapp.room.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContex: Context): AppDatabase =
        Room.databaseBuilder(appContex, AppDatabase::class.java, "db2").build()


    @Provides
    @Singleton
    fun provideDao(Database: AppDatabase) = Database.getDao()


//    @Provides
//    fun providesUserRepository(dbDao: DbDao):NewsRepository=NewsRepository(dbDao)
}