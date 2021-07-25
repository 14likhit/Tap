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
import timber.log.Timber

class Task2ViewModel(private val remoteRepositoryImpl: RemoteRepositoryImpl) : ViewModel() {

    private val imageListMutableLiveData = MutableLiveData<ArrayList<Task2Image>>()
    private val errorData: MutableLiveData<ErrorData> = MutableLiveData()
    private val loadingData: MutableLiveData<Boolean> = MutableLiveData(false)

    var page: Int = 0
    var totalPages = 0

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
        if ((!loadingData.value!!) && (totalPages == 0 || totalPages > page)) {
            loadingData.value = true
            viewModelScope.launch {
                when (val response = remoteRepositoryImpl.getImages(CLIENT_ID, ORDER_BY, page + 1)) {
                    is BaseResponse.Success -> {
                        page += 1
                        if (totalPages == 0) {
                            val totalResultCount = response.data.headers()["X-Total"]?.toInt()
                            val resultPerPage = response.data.headers()["X-Per-Page"]?.toInt()
                            setTotalPages(totalResultCount, resultPerPage)
                        }
                        imageListMutableLiveData.value =
                            mapTask2ImageSchemaToTask2Image(response.data.body())
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

    private fun setTotalPages(resultCount: Int?, resultPerPage: Int?) {
        if (resultCount == null || resultPerPage == null) {
            return
        } else {
            val pages = (resultCount % resultPerPage)
            totalPages = if (pages == 0) {
                (resultCount / resultPerPage)
            } else {
                (resultCount / resultPerPage) + 1
            }
            Timber.d("Result $resultCount & totalPages $totalPages")
        }
    }
}