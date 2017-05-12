package com.recycleritemclickdemo;

import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2017/5/12.
 */
public class RecyclerGestureDetector extends GestureDetector.SimpleOnGestureListener {
    RecyclerItemOnTouchListener recyclerItemOnTouchListener;
    RecyclerView recyclerView;

    public RecyclerGestureDetector(RecyclerView recyclerView, RecyclerItemOnTouchListener recyclerItemOnTouchListener) {
        this.recyclerView = recyclerView;
        this.recyclerItemOnTouchListener = recyclerItemOnTouchListener;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
        if (child != null) {
            RecyclerView.ViewHolder vh = recyclerView.getChildViewHolder(child);
            recyclerItemOnTouchListener.onItemClick(vh);
        }
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        View childe = recyclerView.findChildViewUnder(e.getX(), e.getY());
        if (childe != null) {
            RecyclerView.ViewHolder vh = recyclerView.getChildViewHolder(childe);
            recyclerItemOnTouchListener.onLongItemClick(vh);
        }
    }
}
