package com.team.foodchain

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView

class RecyclerItemClickListener(context:Context, recyclerView:RecyclerView, listener:OnItemClickListener):RecyclerView.OnItemTouchListener {
    private val mListener:OnItemClickListener
    internal var mGestureDetector:GestureDetector
    interface OnItemClickListener {
        fun onItemClick(view:View, position:Int)
        fun onLongItemClick(view:View, position:Int)
    }
    init{
        mListener = listener
        mGestureDetector = GestureDetector(context, object:GestureDetector.SimpleOnGestureListener() {
            override fun onSingleTapUp(e:MotionEvent):Boolean {
                return true
            }
            override fun onLongPress(e:MotionEvent) {
                val child = recyclerView.findChildViewUnder(e.getX(), e.getY())
                if (child != null && mListener != null)
                {
                    Log.d("long", "press")
                    mListener.onLongItemClick(child, recyclerView.getChildAdapterPosition(child))
                }
            }
        })
    }
    override fun onInterceptTouchEvent(view:RecyclerView, e:MotionEvent):Boolean {
        val childView = view.findChildViewUnder(e.getX(), e.getY())
        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e))
        {
            mListener.onItemClick(childView, view.getChildAdapterPosition(childView))
            return true
        }
        return false
    }
    override fun onTouchEvent(view:RecyclerView, motionEvent:MotionEvent) {}
    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept:Boolean) {}
}