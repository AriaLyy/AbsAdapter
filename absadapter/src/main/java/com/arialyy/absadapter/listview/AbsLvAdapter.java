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
package com.arialyy.absadapter.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.arialyy.absadapter.common.AbsHolder;

import java.util.List;

/**
 * Created by Lyy on 2015/3/12.
 * 可扩展的适配器
 */
public abstract class AbsLvAdapter<T, VH extends AbsHolder> extends BaseAdapter {
    private LayoutInflater mInflater;
    protected List<T> mData;
    private Context mContext;

    public AbsLvAdapter(Context context, List<T> data) {
        mInflater = LayoutInflater.from(context);
        mData = data;
        mContext = context;
    }

    protected Context getContext() {
        return mContext;
    }

    /**
     * item 的type
     *
     * @param type
     * @return
     */
    protected abstract int setLayoutId(int type);

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

    public abstract void bindData(int position, VH holder, T item);

    public abstract VH getViewHolder(View convertView);

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VH viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(setLayoutId(getItemViewType(position)), null);
            viewHolder = getViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (VH) convertView.getTag();
        }
        bindData(position, viewHolder, mData.get(position));
        return convertView;
    }
}
