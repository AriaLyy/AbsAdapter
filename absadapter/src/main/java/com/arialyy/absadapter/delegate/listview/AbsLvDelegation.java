package com.arialyy.absadapter.delegate.listview;

import android.content.Context;

import com.arialyy.absadapter.AbsUtil;
import com.arialyy.absadapter.listview.AbsLvHolder;

/**
 * Created by lyy on 2016/3/28.
 * Delegation基类
 */
public abstract class AbsLvDelegation<T, H extends AbsLvHolder> implements AbsILvDelegation<T, H> {
    private int mItemType;
    private Context mContext;
    private AbsLvDAdapter mAdapter;
    private String TAG;

    protected AbsLvDelegation(Context context, AbsLvDAdapter adapter, int itemType) {
        mItemType = itemType;
        mContext = context;
        mAdapter = adapter;
        TAG = AbsUtil.getClassName(this);
    }

    public AbsLvDAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void onNotify() {

    }

    protected Context getContext() {
        return mContext;
    }

    @Override
    public int getItemViewType() {
        return mItemType;
    }
}
