package com.test.myapplication.utils

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

class CanvasView(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : View(
    context, attrs, defStyleAttr
) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}