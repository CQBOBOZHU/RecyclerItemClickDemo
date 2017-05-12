package com.recycleritemclickdemo;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2017/5/12.
 */
public abstract class RecyclerItemOnTouchListener implements RecyclerView.OnItemTouchListener {
    GestureDetectorCompat gestureDetectorCompat;

    public RecyclerItemOnTouchListener(RecyclerView recyclerView) {
        gestureDetectorCompat = new GestureDetectorCompat(recyclerView.getContext(), new RecyclerGestureDetector(recyclerView, this));
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        gestureDetectorCompat.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        gestureDetectorCompat.onTouchEvent(e);
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public abstract void onItemClick(RecyclerView.ViewHolder vh);

    public abstract void onLongItemClick(RecyclerView.ViewHolder vh);
}
