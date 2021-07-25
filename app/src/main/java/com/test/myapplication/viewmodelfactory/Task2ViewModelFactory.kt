package com.test.myapplication.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.myapplication.data.remote.RemoteRepositoryImpl
import com.test.myapplication.viewmodel.Task2ViewModel

class Task2ViewModelFactory(private val remoteRepositoryImpl: RemoteRepositoryImpl) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(Task2ViewModel::class.java)){
            return Task2ViewModel(remoteRepositoryImpl) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}