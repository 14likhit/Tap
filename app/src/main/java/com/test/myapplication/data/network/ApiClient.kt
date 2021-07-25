package com.test.myapplication.data.network

import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Class for retrofit instance creation.
 */
class ApiClient {

    companion object {

        private var retrofit: Retrofit? = null

        private val base_url = "https://api.unsplash.com/"

        /**
         * Method to get retrofit instance
         * @return->Retrofit instance
         */
        fun getRetrofitInstance(): Retrofit? {
            checkNotNull(retrofit) { "ApiClient not initialized, use initialize()" }
            return retrofit
        }

        /**
         * Method to instantiate retrofit instance.
         * @param context->Application Context
         */
        fun initialiseRetrofitInstance(context: Context) {
            if (retrofit == null) {
                val interceptor = HttpLoggingInterceptor()
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

                //Build new Interceptor to cache response
                val httpClient: OkHttpClient = OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()

                retrofit = Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build()
            }
        }
    }

}