package com.arialyy.absadapter.listview;

import android.view.View;

/**
 * Adapter监听
 *
 * @author Administrator
 */
public interface AbsOnAdapterListener {
    /**
     * @param requestCode 请求码
     * @param resultCode  返回码
     * @param position    第几个item
     * @param data        数据
     */
    public <T> void onAdapter(int requestCode, int resultCode, int position, T data);

    public <T> void onAdapter(int position, T data);

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