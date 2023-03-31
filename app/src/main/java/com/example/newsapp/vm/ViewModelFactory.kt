package com.example.newsapp.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.newsapp.api.ApiInterface
import com.example.newsapp.category
import com.example.newsapp.model.Article
import com.example.newsapp.repository.RepoPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelFactory @Inject constructor(private val apiService: ApiInterface ) : ViewModel() {

    val getAllNews: Flow<PagingData<Article>> =
        Pager(config = PagingConfig(10, enablePlaceholders = false,prefetchDistance = 3)) {
            RepoPagingSource(apiService)
        }.flow.cachedIn(viewModelScope)

//    val getAppleNews=apiService.getTopBusiness()
}
