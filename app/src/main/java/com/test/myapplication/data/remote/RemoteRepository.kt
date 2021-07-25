package com.test.myapplication.data.remote

import com.test.myapplication.base.data.BaseResponse
import com.test.myapplication.data.schema.Task2ImageSchema
import retrofit2.Response

interface RemoteRepository {

    suspend fun getImages(
        clientId: String,
        orderBy: String,
        page: Int
    ): BaseResponse<Response<List<Task2ImageSchema>>>
}