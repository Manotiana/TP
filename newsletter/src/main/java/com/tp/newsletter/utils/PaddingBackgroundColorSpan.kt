package com.tp.newsletter.utils

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.text.style.LineBackgroundSpan
import kotlin.math.roundToInt


class PaddingBackgroundColorSpan(private val mBackgroundColor: Int, private val mPadding: Int) : LineBackgroundSpan {
    private val mBgRect: Rect = Rect()
    override fun drawBackground(canvas: Canvas, paint: Paint, left: Int, right: Int, top: Int, baseline: Int, bottom: Int, text: CharSequence, start: Int, end: Int, lineNumber: Int) {
        val textWidth = paint.measureText(text, start, end).roundToInt()
        val paintColor: Int = paint.color
        // Draw the background
        mBgRect.set(left - mPadding,
                top - if (lineNumber == 0) mPadding / 2 else -(mPadding / 2),
                left + textWidth + mPadding,
                bottom + mPadding / 2)
        paint.color = mBackgroundColor
        canvas.drawRect(mBgRect, paint)
        paint.color = paintColor
    }

    init {
        // Precreate rect for performance
    }
}