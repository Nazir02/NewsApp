package com.example.newsapp.repository

import android.util.Log
import androidx.paging.PagingSource
import com.example.newsapp.api.ApiInterface
import com.example.newsapp.model.Article
import retrofit2.HttpException
import java.io.IOException

class RepoPagingSource constructor(private val servic: ApiInterface) :
    PagingSource<Int, Article>() {
    private val DEFAULT_PAGE_INDEX = 1
    override val keyReuseSupported: Boolean = true

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: DEFAULT_PAGE_INDEX
        return try {
            val response = servic.getAppleNews(page, params.loadSize)
            LoadResult.Page(
                response.body()!!.articles,
                prevKey = if (page == DEFAULT_PAGE_INDEX) null else page - 1,
                nextKey = page + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}