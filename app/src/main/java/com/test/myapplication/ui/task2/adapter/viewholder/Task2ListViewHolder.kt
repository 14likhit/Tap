package com.test.myapplication.ui.task2.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.test.myapplication.R
import com.test.myapplication.data.Task2Image
import com.test.myapplication.databinding.ItemTask2ImageBinding
import com.test.myapplication.utils.setImageFromUrlWithError

class Task2ListViewHolder(private val dataBinding: ItemTask2ImageBinding) :
    RecyclerView.ViewHolder(dataBinding.root) {

    fun setData(item: Task2Image) {
        setImageFromUrlWithError(
            itemView.context,
            dataBinding.task2IV,
            item.urls.regular,
            R.drawable.ic_image_placeholder
        )
    }

}