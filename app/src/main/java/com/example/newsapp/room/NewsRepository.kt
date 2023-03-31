package com.example.newsapp.room

import androidx.annotation.WorkerThread
import com.example.newsapp.model.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsDao: DbDao) {
    val getAppleList: Flow<List<Article>> = newsDao.getAppleNews()

    @WorkerThread
    suspend fun insertAppleNews(article: List<Article>) = withContext(Dispatchers.IO) {
        newsDao.insertAppleNews(article)
    }

    @WorkerThread
    suspend fun deleteAppleNews() = withContext(Dispatchers.IO) {
        newsDao.deleteAppleNews()
    }
}