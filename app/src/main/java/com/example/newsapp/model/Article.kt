package com.example.newsapp.model


import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "article")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @Json(name = "author")
    val author: String,
    @Json(name = "content")
    val content: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "publishedAt")
    val publishedAt: String,
//    @Json(name = "source")
//    val source: Source,
    @Json(name = "title")
    val title: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "urlToImage")
    val urlToImage: String
)