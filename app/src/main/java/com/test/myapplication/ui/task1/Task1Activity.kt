package com.test.myapplication.ui.task1

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.test.myapplication.R
import com.test.myapplication.base.BaseActivity
import com.test.myapplication.databinding.ActivityTask1Binding
import com.test.myapplication.utils.OnCollisionListener

class Task1Activity : BaseActivity() {

    private lateinit var dataBinding: ActivityTask1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_task1)

        setupToolbar(getString(R.string.task_1),true)

        setView()

    }

    private fun setView() {
        dataBinding.circleBtn.setOnClickListener {
            dataBinding.canvasView.drawCircle()
        }

        dataBinding.squareBtn.setOnClickListener {
            dataBinding.canvasView.drawSquare()
        }

        dataBinding.undoBtn.setOnClickListener {
            dataBinding.canvasView.undo()
        }

        dataBinding.canvasView.setOnCollisionListener(object : OnCollisionListener{
            override fun onCollision() {
                showMessage("Collision Happened! Try Again")
            }
        })
    }
}