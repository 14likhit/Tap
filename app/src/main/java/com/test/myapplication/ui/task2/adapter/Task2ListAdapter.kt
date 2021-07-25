package com.test.myapplication.ui.task2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.myapplication.data.Task2Image
import com.test.myapplication.databinding.ItemTask2ImageBinding
import com.test.myapplication.ui.task2.adapter.viewholder.Task2ListViewHolder

class Task2ListAdapter(var task2ImageList: ArrayList<Task2Image>) :
    RecyclerView.Adapter<Task2ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Task2ListViewHolder {
        return Task2ListViewHolder(
            ItemTask2ImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Task2ListViewHolder, position: Int) {
        val image = task2ImageList[position]
        holder.setData(image)
    }

    override fun getItemCount(): Int {
        return task2ImageList.size
    }
}