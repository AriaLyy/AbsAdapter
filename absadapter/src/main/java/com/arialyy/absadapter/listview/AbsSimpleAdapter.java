package com.arialyy.absadapter.listview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 通用的Adapter
 *
 * @author Administrator
 */
public abstract class AbsSimpleAdapter<T> extends BaseAdapter {
    /**
     * 请求码
     */
    protected int mRequestCode;
    /**
     * 返回码
     */
    protected int mResultCode;
    /**
     * 监听
     */
    protected AbsOnAdapterListener mListener;
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mData;
    protected final int mItemLayoutId;
    protected int mCurrentPosition = -1;
    protected int mCurrentSelectPosition = -1;
    private int mSelectedColor = Color.parseColor("#afbfff");
    private int mEnSelectedColor = Color.parseColor("#ffffff");

    public AbsSimpleAdapter(Context context, List<T> mData, int itemLayoutId) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.mData = mData;
        this.mItemLayoutId = itemLayoutId;
        int i = 0;
        pre();
    }

    protected void pre() {

    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final AbsSimpleViewHolder viewHolder = getViewHolder(position, convertView,
                parent);
        mCurrentPosition = position;
        View view = viewHolder.getConvertView();
        convert(viewHolder, getItem(position));
        return view;
    }

    /**
     * 设置每一个item的控件的虚函数
     *
     * @param helper
     * @param item
     */
    public abstract void convert(AbsSimpleViewHolder helper, T item);

    /**
     * 设置每个item的控件数据
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    private AbsSimpleViewHolder getViewHolder(int position, View convertView,
                                              ViewGroup parent) {
        return AbsSimpleViewHolder.getViewHolder(mContext, convertView, parent, mItemLayoutId,
                position);
    }

    /**
     * 设置Adapter监听
     *
     * @param mListener
     */
    public void setOnMyAdapterListener(AbsOnAdapterListener mListener) {
        this.mListener = mListener;
    }

    /**
     * 设置数据
     *
     * @param list 数据
     */
    public void setData(List<T> list) {
        mData = list;
        notifyDataSetChanged();
    }

    /**
     * 添加item
     *
     * @param item
     */
    public void addItem(T item) {
        mData.add(item);
        notifyDataSetChanged();
    }

    /**
     * 删除Item
     *
     * @param position
     */
    public void removeItem(int position) {
        mData.remove(position);
        if (mCurrentSelectPosition == position) {
            mCurrentSelectPosition = -1;
        }
        notifyDataSetChanged();
    }
}