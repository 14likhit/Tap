package com.test.myapplication.ui.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.test.myapplication.R
import com.test.myapplication.base.BaseActivity
import com.test.myapplication.databinding.ActivityHomeBinding
import com.test.myapplication.utils.launchTask1Activity
import com.test.myapplication.utils.launchTask2Activity

class HomeActivity : BaseActivity() {

    private lateinit var dataBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        dataBinding.task1Btn.setOnClickListener { launchTask1Activity(this) }

        dataBinding.task2Btn.setOnClickListener { launchTask2Activity(this) }
    }
}