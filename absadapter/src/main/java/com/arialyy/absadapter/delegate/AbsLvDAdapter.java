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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.arialyy.absadapter.common.AbsUtil;
import com.arialyy.absadapter.common.AbsHolder;

import java.util.List;

/**
 * Created by lyy on 2016/3/28.
 * 处理含有多个ViewType的Adapter使用
 */
public abstract class AbsLvDAdapter<T extends AbsDEntity> extends BaseAdapter implements AbsIAdapter<T> {
    private LayoutInflater mInflater;
    protected List<T> mData;
    private Context mContext;
    private AbsDManager mManager = new AbsDManager();
    private String TAG;

    public AbsLvDAdapter(Context context, List<T> data) {
        mInflater = LayoutInflater.from(context);
        mData = data;
        mContext = context;
        TAG = AbsUtil.getClassName(this);
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
    public int getItemViewType(int position) {
        return mData.get(position).getAbsType();
    }

    @Override
    public int getViewTypeCount() {
        return mManager.getMaxType() + 1;
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AbsHolder holder;
        int type = getItemViewType(position);
        AbsIDelegation delegation = mManager.getDelegate(type);
        if (delegation == null) {
            throw new NullPointerException("没有type == " + type + "的Delegate");
        }
        if (convertView == null) {
            convertView = mInflater.inflate(delegation.setLayoutId(), null);
            holder = delegation.createHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (AbsHolder) convertView.getTag();
        }
        delegation.bindData(position, holder, mData.get(position));
        return convertView;
    }
}
