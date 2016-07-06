/*
 * Copyright (C) 2016 AriaLyy(AbsAdapter)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.arialyy.absadapter.delegate;

import android.content.Context;
import android.util.Log;

import com.arialyy.absadapter.common.AbsUtil;
import com.arialyy.absadapter.common.AbsHolder;
import com.arialyy.absadapter.recycler_view.AbsRVAdapter;

/**
 * Created by lyy on 2016/3/28.
 * Delegation基类
 */
public abstract class AbsDelegation<T extends AbsDEntity, H extends AbsHolder> implements AbsIDelegation<T, H> {
    private int mItemType;
    private Context mContext;
    private AbsIAdapter mAdapter;
    private String TAG;

    public AbsDelegation(Context context, AbsIAdapter adapter, int itemType) {
        mItemType = itemType;
        mContext = context;
        mAdapter = adapter;
        TAG = AbsUtil.getClassName(this);
    }

    public AbsIAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void notifyDataSetChanged() {
        if (mAdapter instanceof AbsLvDAdapter) {
            ((AbsLvDAdapter) mAdapter).notifyDataSetChanged();
        } else if (mAdapter instanceof AbsRVAdapter) {
            ((AbsRVAdapter) mAdapter).notifyDataSetChanged();
        }
    }

    @Override
    public void notifyDataSetChanged(int position) {
        if (mAdapter instanceof AbsRVAdapter) {
            ((AbsRVAdapter) mAdapter).notifyItemChanged(position);
        } else {
            Log.e(TAG, "该方法只能用于RecyclerView");
        }
    }

    protected Context getContext() {
        return mContext;
    }

    @Override
    public int getItemViewType() {
        return mItemType;
    }
}
