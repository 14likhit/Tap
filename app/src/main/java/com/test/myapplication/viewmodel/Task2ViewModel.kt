package com.test.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.myapplication.base.data.BaseResponse
import com.test.myapplication.base.data.ErrorData
import com.test.myapplication.data.Task2Image
import com.test.myapplication.data.remote.RemoteRepositoryImpl
import com.test.myapplication.utils.CLIENT_ID
import com.test.myapplication.utils.ORDER_BY
import com.test.myapplication.utils.mapTask2ImageSchemaToTask2Image
import kotlinx.coroutines.launch

class Task2ViewModel(private val remoteRepositoryImpl: RemoteRepositoryImpl) : ViewModel() {

    private val imageListMutableLiveData = MutableLiveData<ArrayList<Task2Image>>()
    private val errorData: MutableLiveData<ErrorData> = MutableLiveData()
    private val loadingData: MutableLiveData<Boolean> = MutableLiveData()

    var page: Int = 0

    fun getImageListLiveData(): LiveData<ArrayList<Task2Image>> {
        return imageListMutableLiveData
    }

    fun getErrorLiveData(): LiveData<ErrorData> {
        return errorData
    }

    fun getLoadingData(): LiveData<Boolean> {
        return loadingData
    }

    fun getImages() {
        loadingData.value = true
        viewModelScope.launch {
            when (val response = remoteRepositoryImpl.getImages(CLIENT_ID, ORDER_BY, page++)) {
                is BaseResponse.Success -> {
                    imageListMutableLiveData.value = mapTask2ImageSchemaToTask2Image(response.data)
                    loadingData.value = false
                }
                is BaseResponse.Error -> {
                    errorData.value = response.errorData
                    loadingData.value = false
                }
            }
        }
    }

}