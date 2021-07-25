package com.test.myapplication.data.remote

import com.test.myapplication.base.data.BaseResponse
import com.test.myapplication.data.schema.Task2ImageSchema

interface RemoteRepository {

    suspend fun getTrendingGitRepositories(
        clientId: String,
        orderBy: String,
        page: Int
    ): BaseResponse<List<Task2ImageSchema>>
}