package com.monofire.paging3sampleapp.data.datasource

import androidx.paging.PagingSource
import com.monofire.paging3sampleapp.data.ApiService
import com.monofire.paging3sampleapp.data.response.Data
import java.lang.Exception

class PostDataSource(private val apiService: ApiService) : PagingSource<Int, Data>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        try {
            val currentLoadingPageKey = params.key ?: 1
            val response = apiService.getListData(currentLoadingPageKey)
            val responseData = mutableListOf<Data>()
            val data = response.body()?.data ?: emptyList()
            responseData.addAll(data)

            val prevKey = if (currentLoadingPageKey == 1) null else currentLoadingPageKey - 1

            return LoadResult.Page(
                data = responseData,
                prevKey = prevKey,
                nextKey = currentLoadingPageKey.plus(1)
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}