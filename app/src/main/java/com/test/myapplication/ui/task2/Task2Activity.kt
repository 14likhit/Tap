package com.test.myapplication.ui.task2

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.myapplication.R
import com.test.myapplication.base.BaseActivity
import com.test.myapplication.base.data.ErrorData
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
        showError(false, null)

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
            val error = it
            if (error != null) {
                showError(true, error)
            }
        })

        task2ViewModel.getLoadingData().observe(this, {
            val loading = it
            if (loading != null) {
                showLoading(loading)
            }
        })
    }

    private fun setView() {

        setupToolbar(getString(R.string.task_2), true)

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
                        getImages()
                    }
                }
            }
        })

        getImages()
    }

    private fun getImages() {
        task2ViewModel.getImages()
    }

    private fun showLoading(loading: Boolean) {
        if (loading) {
            dataBinding.loadingPB.visibility = View.VISIBLE
        } else {
            dataBinding.loadingPB.visibility = View.GONE
        }
    }

    private fun showError(isError: Boolean, errorData: ErrorData?) {
        if (isError && errorData != null) {
            dataBinding.errorLayout.errorTV.text = errorData.message
            dataBinding.errorLayout.retryBtn.setOnClickListener {
                getImages()
                showError(false, null)
            }
            dataBinding.errorLayout.errorRootLL.visibility = View.VISIBLE
        } else {
            dataBinding.errorLayout.errorRootLL.visibility = View.GONE
        }
    }
}