package com.example.newsapp.room

import androidx.paging.PagingData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsapp.model.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface DbDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAppleNews(newsModel: List<Article>)

    @Query("SELECT * from Article")
    fun getAppleNews():Flow<List<Article>>

    @Query("delete FROM  Article")
    suspend fun deleteAppleNews()



}