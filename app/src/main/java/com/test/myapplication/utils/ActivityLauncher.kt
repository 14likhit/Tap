package com.test.myapplication.utils

import android.content.Intent
import com.test.myapplication.base.BaseActivity
import com.test.myapplication.ui.task1.Task1Activity
import com.test.myapplication.ui.task2.Task2Activity

fun launchTask1Activity(activity: BaseActivity){
    Intent(activity, Task1Activity::class.java).apply {
        activity.startActivity(this)
    }
}

fun launchTask2Activity(activity: BaseActivity){
    Intent(activity,Task2Activity::class.java).apply {
        activity.startActivity(this)
    }
}