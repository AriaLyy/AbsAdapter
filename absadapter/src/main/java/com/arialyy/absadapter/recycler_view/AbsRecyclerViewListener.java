package com.arialyy.absadapter.recycler_view;

import android.view.View;

/**
 * Created by Carlton on 2015/4/22.
 */
public interface AbsRecyclerViewListener {
    /**
     * item点击接口
     */
    public interface OnItemClickListener {
        public void onItemClick(View v, int position);
    }

    /**
     * item长按接口
     */
    public interface OnItemLongClickListener {
        public void onItemLongClick(View v, int position);
    }
}
