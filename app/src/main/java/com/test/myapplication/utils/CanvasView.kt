package com.test.myapplication.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
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
    private val radius = 100F
    private val length = 100
    private val random = Random()

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
        val x = random.nextInt(width).toFloat()
        val y = random.nextInt(height).toFloat()
        val path = Path()
        path.addCircle(x, y, radius, Path.Direction.CW)
        pathList.add(path)
        drawPaths(canvas)
    }

    private fun drawRandomSquareOnCanvas(canvas: Canvas?) {
        val x = random.nextInt(width).toFloat()
        val y = random.nextInt(height).toFloat()
        val path = Path()
        val min = min(x, y)
        path.addRect(min, min, min + length, min + length, Path.Direction.CW)
        pathList.add(path)
        drawPaths(canvas)
    }

    private fun checkIfIntersect(inputPath: Path): Boolean{
        var isIntersecting = false
        for(path in pathList){
            if(inputPath.op(path,Path.Op.INTERSECT)){
                isIntersecting = true
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
}