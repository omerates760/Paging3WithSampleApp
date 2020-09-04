package com.monofire.paging3sampleapp.data.response

data class ApiResponse(
    val ad: Ad,
    val data: List<Data>,
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int
)