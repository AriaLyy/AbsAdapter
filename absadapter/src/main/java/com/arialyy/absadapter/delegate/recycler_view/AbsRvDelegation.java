package com.arialyy.absadapter.delegate.recycler_view;

import android.content.Context;

import com.arialyy.absadapter.delegate.AbsDEntity;
import com.arialyy.absadapter.recycler_view.AbsRVHolder;


/**
 * Created by lyy on 2016/5/30.
 */
public abstract class AbsRvDelegation<T extends AbsDEntity, H extends AbsRVHolder> implements AbsIRvDelegation<T, H> {
    private int mItemType;
    private Context mContext;
    private AbsRvDAdapter mAdapter;

    public AbsRvDelegation(Context context, AbsRvDAdapter adapter, int itemType) {
        mItemType = itemType;
        mContext = context;
        mAdapter = adapter;
    }

    public AbsRvDAdapter getAdapter() {
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
