package com.test.myapplication.base

import android.app.Application
import com.test.myapplication.BuildConfig
import com.test.myapplication.data.network.ApiClient
import timber.log.Timber

class Tap : Application() {

    override fun onCreate() {
        super.onCreate()
        ApiClient.initialiseRetrofitInstance(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}