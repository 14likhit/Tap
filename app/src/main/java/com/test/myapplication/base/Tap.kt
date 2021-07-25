package com.test.myapplication.base

import android.app.Application
import com.test.myapplication.data.network.ApiClient

class Tap : Application() {

    override fun onCreate() {
        super.onCreate()
        ApiClient.initialiseRetrofitInstance(this)
    }
}