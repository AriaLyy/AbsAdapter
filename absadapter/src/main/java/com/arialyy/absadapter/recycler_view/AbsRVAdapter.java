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
package com.arialyy.absadapter.recycler_view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arialyy.absadapter.common.AbsHolder;
import com.arialyy.absadapter.common.AbsUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyy on 2015/12/3.
 * RecyclerView 通用Adapter
 */
public abstract class AbsRVAdapter<T, Holder extends AbsHolder> extends RecyclerView.Adapter<Holder> {
    protected String TAG;
    protected List<T> mData = new ArrayList<>();
    protected Context mContext;
    Holder holder;

    public AbsRVAdapter(Context context, List<T> data) {
        mData = data;
        mContext = context;
        TAG = AbsUtil.getClassName(this);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(setLayoutId(viewType), parent, false);
        holder = getViewHolder(view, viewType);
        return holder;
    }

    protected abstract Holder getViewHolder(View convertView, int viewType);

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        bindData(holder, position, mData.get(position));
    }

    public Context getContext() {
        return mContext;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * item 的type
     *
     * @param type
     * @return
     */
    protected abstract int setLayoutId(int type);

    protected abstract void bindData(Holder holder, int position, T item);
}
