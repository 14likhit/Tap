package com.test.myapplication.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.test.myapplication.TestCoroutineRule
import com.test.myapplication.base.data.BaseResponse
import com.test.myapplication.base.data.ErrorData
import com.test.myapplication.data.Task2Image
import com.test.myapplication.data.remote.RemoteRepositoryImpl
import com.test.myapplication.data.schema.Task2ImageSchema
import com.test.myapplication.sampledata.getTask2ImageList
import com.test.myapplication.sampledata.getTask2ImageSchemaList
import com.test.myapplication.utils.CLIENT_ID
import com.test.myapplication.utils.ORDER_BY
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class Task2ViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var testCoroutineRule = TestCoroutineRule()

    private lateinit var SUT: Task2ViewModel

    @Captor
    private lateinit var imageListMutableLiveDataArgument: ArgumentCaptor<ArrayList<Task2Image>>

    @Captor
    private lateinit var errorMutableLiveDataArgument: ArgumentCaptor<ErrorData>

    @Mock
    private lateinit var imageListMutableLiveDataObserver: Observer<ArrayList<Task2Image>>

    @Mock
    private lateinit var errorMutableDataObserver: Observer<ErrorData>

    @Mock
    private lateinit var apiRepositoryImpl: RemoteRepositoryImpl

    @Before
    fun setUp() {
        SUT = Task2ViewModel(apiRepositoryImpl)
    }

    @Test
    fun getImages_success_listOfTask2ImagesReturned() {
        testCoroutineRule.runBlockingTest {
            val task2ImageList = getTask2ImageList()
            val response = Response.success(getTask2ImageSchemaList())
            doReturn(BaseResponse.Success(response)).`when`(apiRepositoryImpl).getImages(
                CLIENT_ID,
                ORDER_BY, 1
            )
            SUT.getImageListLiveData().observeForever(imageListMutableLiveDataObserver)
            SUT.getImages()
            verify(apiRepositoryImpl).getImages(CLIENT_ID, ORDER_BY, 1)
            verify(imageListMutableLiveDataObserver).onChanged(imageListMutableLiveDataArgument.capture())
            assertEquals(task2ImageList, imageListMutableLiveDataArgument.value)
            SUT.getImageListLiveData().removeObserver(imageListMutableLiveDataObserver)
        }
    }

    @Test
    fun getImages_successEmpty_listOfTask2ImagesReturned() {
        testCoroutineRule.runBlockingTest {
            val task2ImageList = arrayListOf<Task2Image>()
            val response = Response.success(emptyList<Task2ImageSchema>())
            doReturn(BaseResponse.Success(response)).`when`(apiRepositoryImpl).getImages(
                CLIENT_ID,
                ORDER_BY, 1
            )
            SUT.getImageListLiveData().observeForever(imageListMutableLiveDataObserver)
            SUT.getImages()
            verify(apiRepositoryImpl).getImages(CLIENT_ID, ORDER_BY, 1)
            verify(imageListMutableLiveDataObserver).onChanged(imageListMutableLiveDataArgument.capture())
            assertEquals(task2ImageList, imageListMutableLiveDataArgument.value)
            SUT.getImageListLiveData().removeObserver(imageListMutableLiveDataObserver)
        }
    }

    @Test
    fun getImages_successNull_listOfTask2ImagesReturned() {
        testCoroutineRule.runBlockingTest {
            val task2ImageList = arrayListOf<Task2Image>()
            val response = Response.success(null)
            doReturn(BaseResponse.Success(response)).`when`(apiRepositoryImpl).getImages(
                CLIENT_ID,
                ORDER_BY, 1
            )
            SUT.getImageListLiveData().observeForever(imageListMutableLiveDataObserver)
            SUT.getImages()
            verify(apiRepositoryImpl).getImages(CLIENT_ID, ORDER_BY, 1)
            verify(imageListMutableLiveDataObserver).onChanged(imageListMutableLiveDataArgument.capture())
            assertEquals(task2ImageList, imageListMutableLiveDataArgument.value)
            SUT.getImageListLiveData().removeObserver(imageListMutableLiveDataObserver)
        }
    }

    @Test
    fun getImages_error_ErrorDataReturned() {
        testCoroutineRule.runBlockingTest {
            val errorData = ErrorData(Throwable(), "")
            doReturn(BaseResponse.Error(errorData)).`when`(apiRepositoryImpl).getImages(
                CLIENT_ID,
                ORDER_BY, 1
            )
            SUT.getErrorLiveData().observeForever(errorMutableDataObserver)
            SUT.getImages()
            verify(apiRepositoryImpl).getImages(
                CLIENT_ID,
                ORDER_BY, 1
            )
            verify(errorMutableDataObserver).onChanged(errorMutableLiveDataArgument.capture())
            assertEquals(errorData, errorMutableLiveDataArgument.value)
            SUT.getErrorLiveData().removeObserver(errorMutableDataObserver)
        }
    }

}