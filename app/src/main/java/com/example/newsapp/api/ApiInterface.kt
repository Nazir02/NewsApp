package com.example.newsapp.api

import com.example.newsapp.model.model
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("everything?q=tesla&from=2022-10-29&sortBy=publishedAt&apiKey=75b9a3d02ea540439e24b84bfc312152")
    suspend fun getAppleNews(
        @Query("page") page:Int,
        @Query("limit") limit:Int
    ): Response<model>

    @GET("top-headlines?country=us&category=business&apiKey=75b9a3d02ea540439e24b84bfc312152")
    suspend fun getTopBusiness():Response<model>

}