package com.jun.delibary.adapters

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation
import androidx.recyclerview.widget.RecyclerView
import com.jun.delibary.model.prepareData


fun View.expand(scrollView: RecyclerView?=null) {
    measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    val actualHeight = measuredHeight
    Log.d("response", "${actualHeight}")
    layoutParams.height = 0
    visibility = View.VISIBLE
    val animation: Animation = object : Animation() {
        override fun applyTransformation(
                interpolatedTime: Float,
                t: Transformation
        ) {
            layoutParams.height =
                    if (interpolatedTime == 1f) actualHeight else (actualHeight * interpolatedTime).toInt()
            Log.d("response", "${layoutParams.height}")
            requestLayout()
        }
    }
    /** REPEATING FOR VIDEO **/
    animation.setAnimationListener(object: Animation.AnimationListener{
        override fun onAnimationRepeat(animation: Animation?) {
        }

        override fun onAnimationEnd(animation: Animation?) {
            scrollView?.run{
                smoothScrollToPosition(prepareData().size-1)
                // smoothScrollTo(0, bottom) 스크롤뷰
            }
        }

        override fun onAnimationStart(animation: Animation?) {

        }

    })
    animation.duration = (actualHeight / context.resources.displayMetrics.density).toLong()
    Log.d("response3"," ${actualHeight}")
    startAnimation(animation)
}

fun View.collapse() {
    val actualHeight: Int = measuredHeight
    val animation: Animation = object : Animation() {
        override fun applyTransformation(
                interpolatedTime: Float,
                t: Transformation?
        ) {
            if (interpolatedTime == 1f) {
                visibility = View.GONE
            } else {
                layoutParams.height =
                        actualHeight - (actualHeight * interpolatedTime).toInt()
                requestLayout()
            }
        }
    }

    animation.duration =
            (actualHeight / context.resources.displayMetrics.density).toLong()
    startAnimation(animation)
}