package com.arialyy.absadapter.recycler_view;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by lyy on 2015/12/3.
 * RecyclerView 通用Holder
 */
public class AbsRVHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    private OnItemClickListener mClick;
    private OnItemLongClickListener mLongClick;

    View mView;
    private SparseArray<View> mViews = new SparseArray<>();


    public interface OnItemClickListener {
        public void onItemClick(View parent, int position);
    }

    public interface OnItemLongClickListener {
        public void onItemLongClick(View parent, int position);
    }

    @Override
    public void onClick(View v) {
        if (mClick != null) {
            mClick.onItemClick(v, getLayoutPosition());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (mLongClick != null) {
            mLongClick.onItemLongClick(v, getLayoutPosition());
        }
        return false;
    }

    public void setItemClickListener(OnItemClickListener mClick) {
        this.mClick = mClick;
    }

    public void setItemLongClickListener(OnItemLongClickListener mLongClick) {
        this.mLongClick = mLongClick;
    }

    public AbsRVHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T getView(@IdRes int id) {
        View view = mViews.get(id);
        if (view == null) {
            view = mView.findViewById(id);
            mViews.put(id, view);
        }
        return (T) view;
    }

}
