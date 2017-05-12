package com.recycleritemclickdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyRecyclerAdapter.ItemClickListener,MyRecyclerAdapter.ItemLongClickListener {
    RecyclerView recyclerView;
    String[] md = new String[20];
    MyRecyclerAdapter adapter;
    long startTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new MyRecyclerAdapter(this, md);
        recyclerView.setAdapter(adapter);
        //方法一:
//        adapter.setItemClickListener(this);
//        adapter.setItemLongClickListener(this);
//        //方法二:

//        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//            @Override
//            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
//                switch (e.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        startTime = System.currentTimeMillis();
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        long endTime = System.currentTimeMillis();
//                        View childView = rv.findChildViewUnder(e.getX(), e.getY());
//                        int position = recyclerView.getChildAdapterPosition(childView);
//                        if (endTime - startTime < 300) {
//                            Toast.makeText(MainActivity.this, "onInterceptTouchEvent 点击" + position, Toast.LENGTH_SHORT).show();
//                            //点击
//                        } else {
//                            //长按
//                            Toast.makeText(MainActivity.this, "onInterceptTouchEvent 长按" + position, Toast.LENGTH_SHORT).show();
//                        }
//                        break;
//                }
//
//                return false;
//            }
//
//            @Override
//            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
//
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//
//            }
//        });

        //方法三:
        recyclerView.addOnItemTouchListener(new RecyclerItemOnTouchListener(recyclerView) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
                Toast.makeText(MainActivity.this, "方法三：单击" + vh.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(RecyclerView.ViewHolder vh) {
                Toast.makeText(MainActivity.this, "方法三：长按" + vh.getAdapterPosition(), Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public void itemClick(int position) {
        Toast.makeText(this, "adapter 设置item点击" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void itemLongClick(int position) {
        Toast.makeText(this, "adapter 设置item长按" + position, Toast.LENGTH_SHORT).show();
    }
}
