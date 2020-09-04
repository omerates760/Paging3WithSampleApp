package com.monofire.paging3sampleapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.monofire.paging3sampleapp.data.ApiService

class MainViewModelFactory(private val apiService: ApiService) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(apiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}