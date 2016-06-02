package com.arialyy.absadapter.delegate.listview;

import android.content.Context;

/**
 * Created by lyy on 2016/3/28.
 * Delegation基类
 */
public abstract class AbsLvDelegation<T, H extends AbsLvDHolder> implements AbsILvDelegation<T, H> {
    private int mItemType;
    private Context mContext;

    protected AbsLvDelegation(Context context, int itemType) {
        mItemType = itemType;
        mContext = context;
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
