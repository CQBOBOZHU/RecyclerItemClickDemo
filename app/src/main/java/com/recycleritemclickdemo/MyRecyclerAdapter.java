package com.recycleritemclickdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by Administrator on 2017/5/12.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyRecyclerViewHolder> {
    String[] mData;
    Context mContext;
    LayoutInflater inflater;

    public MyRecyclerAdapter(Context mContext, String[] mData) {
        this.mData = mData;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recycler, parent, false);
        return new MyRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewHolder holder, final int position) {
        holder.setText(R.id.item_tv, "这是数据" + position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.itemClick(position);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (itemLongClickListener != null)
                    itemLongClickListener.itemLongClick(position);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    ItemClickListener itemClickListener;
    ItemLongClickListener itemLongClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setItemLongClickListener(ItemLongClickListener itemLongClickListener) {
        this.itemLongClickListener = itemLongClickListener;
    }

    interface ItemClickListener {
        void itemClick(int position);
    }

    interface ItemLongClickListener {
        void itemLongClick(int position);
    }


    class MyRecyclerViewHolder extends RecyclerView.ViewHolder {
        SparseArray<View> views;

        public MyRecyclerViewHolder(View itemView) {
            super(itemView);
            views = new SparseArray<>();
        }

        public <T extends View> T getView(int id) {
            View view = views.get(id);
            if (view == null) {
                view = itemView.findViewById(id);
                views.put(id, view);
            }
            return (T) view;
        }

        public MyRecyclerViewHolder setText(int id, CharSequence sequence) {
            View view = getView(id);
            if (view instanceof TextView) {
                ((TextView) view).setText(sequence);
            } else if (view instanceof Button) {
                ((Button) view).setText(sequence);
            }
            return this;
        }
    }
}
