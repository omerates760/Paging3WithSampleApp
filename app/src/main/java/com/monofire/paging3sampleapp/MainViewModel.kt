package com.monofire.paging3sampleapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.monofire.paging3sampleapp.data.ApiService
import com.monofire.paging3sampleapp.data.datasource.PostDataSource

class MainViewModel(private val apiService: ApiService) : ViewModel() {

    val listData = Pager(PagingConfig(pageSize = 6)) {
        PostDataSource(apiService)
    }.flow.cachedIn(viewModelScope)

}