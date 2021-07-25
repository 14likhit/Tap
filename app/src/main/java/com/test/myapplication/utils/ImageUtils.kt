package com.test.myapplication.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

fun setImageFromUrlWithError(context: Context, imageView: ImageView, url: String?, drawable: Int) {
    Glide.with(context).load(url)
        .error(drawable)
        .into(object : CustomTarget<Drawable?>() {
            override fun onResourceReady(
                resource: Drawable,
                transition: Transition<in Drawable?>?
            ) {
                imageView.setImageDrawable(resource)
            }

            override fun onLoadCleared(placeholder: Drawable?) {}
        })
}