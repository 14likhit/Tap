package com.test.myapplication.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Region
import android.util.AttributeSet
import android.view.View
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min

class CanvasView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(
    context, attrs, defStyleAttr
) {

    private val pathList = ArrayList<Path>()

    private var shapeToDraw = 0
    private val paint = Paint()
    private val radius = 100
    private val length = 100
    private val random = Random()

    private var onCollisionListener: OnCollisionListener? = null

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        when (shapeToDraw) {
            0 -> {
                drawPaths(canvas)
            }
            1 -> {
                drawRandomCircleOnCanvas(canvas)
            }
            2 -> {
                drawRandomSquareOnCanvas(canvas)
            }
        }
    }

    private fun drawRandomCircleOnCanvas(canvas: Canvas?) {
        val xleftMin = radius
        val xRightMin = width - radius
        val ybottom = radius
        val yTopMin = height - radius
        val x = (xleftMin..xRightMin).random().toFloat()
        val y = (ybottom..yTopMin).random().toFloat()
        val path = Path()
        path.addCircle(x, y, radius.toFloat(), Path.Direction.CW)
        if (!checkIfIntersect(path)) {
            pathList.add(path)
            drawPaths(canvas)
        } else {
            drawPaths(canvas)
        }
    }

    private fun drawRandomSquareOnCanvas(canvas: Canvas?) {
        val xleftMin = 0
        val xRightMin = width - length
        val ybottom = 0
        val yTopMin = height - length
        val x = (xleftMin..xRightMin).random().toFloat()
        val y = (ybottom..yTopMin).random().toFloat()
        val path = Path()
        val min = min(x, y)
        path.addRect(min, min, min + length, min + length, Path.Direction.CW)
        if (!checkIfIntersect(path)) {
            pathList.add(path)
            drawPaths(canvas)
        } else {
            drawPaths(canvas)
        }
    }

    private fun checkIfIntersect(inputPath: Path): Boolean {
        val clip = Region(0, 0, width, height)
        val i1 = Region()
        i1.setPath(inputPath, clip)
        var isIntersecting = false
        for (path in pathList) {
            val r1 = Region()
            r1.setPath(path, clip)
            if (!r1.quickReject(i1) && r1.op(i1, Region.Op.INTERSECT)) {
                isIntersecting = true
                onCollisionListener?.onCollision()
                break
            }
        }
        return isIntersecting
    }

    private fun drawPaths(canvas: Canvas?) {
        if (pathList.isNotEmpty()) {
            for (path in pathList) {
                canvas?.drawPath(path, paint)
            }
        }
    }

    fun drawCircle() {
        shapeToDraw = 1
        invalidate()
    }

    fun drawSquare() {
        shapeToDraw = 2
        invalidate()
    }

    fun undo() {
        shapeToDraw = 0
        if (pathList.isNotEmpty()) {
            pathList.removeLast()
        }
        invalidate()
    }

    fun setOnCollisionListener(listener: OnCollisionListener) {
        onCollisionListener = listener
    }
}