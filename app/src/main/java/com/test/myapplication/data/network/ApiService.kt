package com.test.myapplication.data.network

import com.test.myapplication.data.schema.Task2ImageSchema
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Service to implement all Api endpoints
 */
interface ApiService {

    @GET("photos")
    suspend fun getImages(
        @Query("client_id") clientId: String,
        @Query("order_by") orderBy: String,
        @Query("page") page: Int
    ): Response<List<Task2ImageSchema>>

}