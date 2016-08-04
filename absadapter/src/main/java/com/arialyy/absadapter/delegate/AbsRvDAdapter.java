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
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arialyy.absadapter.common.AbsUtil;
import com.arialyy.absadapter.common.AbsHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyy on 2016/5/30.
 */
public abstract class AbsRvDAdapter<T extends AbsDEntity> extends RecyclerView.Adapter implements AbsIAdapter<T> {
    protected String TAG;
    protected List<T> mData = new ArrayList<>();
    protected Context mContext;
    private AbsDManager mManager = new AbsDManager();

    public AbsRvDAdapter(Context context, List<T> data) {
        mData = data;
        mContext = context;
        TAG = AbsUtil.getClassName(this);
    }

    /**
     * 删除样式
     *
     * @param clazz Delegation 的class
     */
    public void delDelegate(Class clazz) {
        mManager.delDelegate((List<AbsDEntity>) mData, clazz);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getAbsType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AbsIDelegation delegation = mManager.getDelegate(viewType);
        if (delegation == null) {
            throw new NullPointerException("没有type == " + viewType + "的Delegate");
        }
        return delegation.createViewHolder(parent, viewType);
    }

    @Override
    public AbsDManager getManager() {
        return mManager;
    }

    @Override
    public List<T> getData() {
        return mData;
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int            type       = getItemViewType(position);
        AbsIDelegation delegation = mManager.getDelegate(type);
        if (delegation == null) {
            throw new NullPointerException("没有type == " + type + "，的Delegate");
        }
        if (holder instanceof AbsHolder) {
            delegation.bindData(position, (AbsHolder) holder, mData.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
