package com.arialyy.absadapter.recycler_view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arialyy.absadapter.AbsUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyy on 2015/12/3.
 * RecyclerView 通用Adapter
 */
public abstract class AbsRVAdapter<T, Holder extends AbsRVHolder> extends RecyclerView.Adapter<Holder> {
    protected String TAG;
    protected List<T> mData = new ArrayList<>();
    protected Context mContext;
    Holder holder;
    protected AbsRVHolder.OnItemClickListener mItemClickListener;
    protected AbsRVHolder.OnItemLongClickListener mItemLongClickListener;

    public AbsRVAdapter(Context context, List<T> data) {
        mData = data;
        mContext = context;
        TAG = AbsUtil.getClassName(this);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(setLayoutId(viewType), parent, false);
        holder = getViewHolder(view, viewType);
        if (mItemClickListener != null) {
            holder.setItemClickListener(mItemClickListener);
        }
        if (mItemLongClickListener != null) {
            holder.setItemLongClickListener(mItemLongClickListener);
        }
        return holder;
    }

    protected abstract Holder getViewHolder(View convertView, int viewType);

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        bindData(holder, position, mData.get(position));
    }

    public Context getContext() {
        return mContext;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setOnItemClickListener(AbsRVHolder.OnItemClickListener clickListener) {
        mItemClickListener = clickListener;
    }

    public void setOnItemLongClickListener(AbsRVHolder.OnItemLongClickListener longClickListener) {
        mItemLongClickListener = longClickListener;
    }

    /**
     * item 的type
     *
     * @param type
     * @return
     */
    protected abstract int setLayoutId(int type);

    protected abstract void bindData(Holder holder, int position, T item);
}
