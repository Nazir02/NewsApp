package com.example.newsapp.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.newsapp.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModelDB @Inject constructor(private val newsRepository: NewsRepository) :
    ViewModel() {

    val getAppleList: LiveData<List<Article>>
        get() =
            newsRepository.getAppleList.flowOn(Dispatchers.Main)
                .asLiveData(context = viewModelScope.coroutineContext)


    fun insertAppleNews(article: List<Article>){
        viewModelScope.launch {
            newsRepository.insertAppleNews(article)
        }
    }

    fun deleteAppleNews(){
        viewModelScope.launch {
            newsRepository.deleteAppleNews()
        }
    }
}