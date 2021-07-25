package com.test.myapplication.ui.task2

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.myapplication.R
import com.test.myapplication.base.BaseActivity
import com.test.myapplication.data.Task2Image
import com.test.myapplication.data.network.ApiClient
import com.test.myapplication.data.network.ApiService
import com.test.myapplication.data.remote.RemoteRepositoryImpl
import com.test.myapplication.databinding.ActivityTask2Binding
import com.test.myapplication.ui.task2.adapter.Task2ListAdapter
import com.test.myapplication.viewmodel.Task2ViewModel
import com.test.myapplication.viewmodelfactory.Task2ViewModelFactory
import kotlinx.coroutines.Dispatchers

class Task2Activity : BaseActivity() {

    private lateinit var dataBinding: ActivityTask2Binding

    private lateinit var task2ViewModeFactory: Task2ViewModelFactory
    private lateinit var task2ViewModel: Task2ViewModel

    private val task2List = ArrayList<Task2Image>()
    private val task2ListAdapter by lazy { Task2ListAdapter(task2List) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_task2)

        task2ViewModeFactory = Task2ViewModelFactory(
            RemoteRepositoryImpl.getInstance(
                ApiClient.getRetrofitInstance()!!.create(ApiService::class.java),
                Dispatchers.IO
            )!!
        )

        task2ViewModel =
            ViewModelProvider(this, task2ViewModeFactory).get(Task2ViewModel::class.java)

        setObservers()
        setView()
    }

    private fun setObservers() {
        task2ViewModel.getImageListLiveData().observe(this, {
            val imageList = it
            if (imageList != null) {
                task2List.addAll(imageList)
                task2ListAdapter.notifyDataSetChanged()
            }
        })

        task2ViewModel.getErrorLiveData().observe(this, {

        })

        task2ViewModel.getLoadingData().observe(this, {

        })
    }

    private fun setView() {
        dataBinding.task2ImageListRV.apply {
            adapter = task2ListAdapter
        }

        dataBinding.task2ImageListRV.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) {
                    val visibleThreshold = 2
                    val layoutManager =
                        dataBinding.task2ImageListRV.layoutManager as GridLayoutManager
                    val lastItem = layoutManager.findLastCompletelyVisibleItemPosition()
                    val currentTotalCount = layoutManager.itemCount
                    if (currentTotalCount <= lastItem + visibleThreshold) {
                        task2ViewModel.getImages()
                    }
                }
            }
        })

        task2ViewModel.getImages()
    }
}