package com.test.myapplication.data.remote

import com.test.myapplication.base.data.BaseResponse
import com.test.myapplication.base.data.baseApiCall
import com.test.myapplication.data.network.ApiService
import com.test.myapplication.data.schema.Task2ImageSchema
import kotlinx.coroutines.CoroutineDispatcher

class RemoteRepositoryImpl(
    private val service: ApiService,
    private val ioDispatcher: CoroutineDispatcher
) : RemoteRepository {

    companion object {
        fun getInstance(
            apiService: ApiService,
            ioDispatcher: CoroutineDispatcher
        ): RemoteRepositoryImpl? {
            if (mInstance == null) {
                mInstance = RemoteRepositoryImpl(apiService, ioDispatcher)
            }
            return mInstance
        }

        private var mInstance: RemoteRepositoryImpl? = null
    }


    override suspend fun getTrendingGitRepositories(
        clientId: String,
        orderBy: String,
        page: Int
    ): BaseResponse<List<Task2ImageSchema>> {
        return baseApiCall(ioDispatcher) {
            service.getImages(clientId, orderBy, page)
        }
    }
}