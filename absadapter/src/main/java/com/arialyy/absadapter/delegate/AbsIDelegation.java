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

import android.view.View;

import com.arialyy.absadapter.common.AbsHolder;

/**
 * Created by lyy on 2016/5/30.
 */
interface AbsIDelegation<T, H extends AbsHolder> {
    /**
     * 更新
     */
    public void notifyDataSetChanged();

    /**
     * 更新指定的数据，recyclerView使用
     *
     * @param position
     */
    public void notifyDataSetChanged(int position);

    /**
     * 获取adapter
     */
    public AbsIAdapter getAdapter();

    /**
     * 设置布局
     *
     * @return
     */
    public int setLayoutId();

    /**
     * item的viewType
     *
     * @return
     */
    public int getItemViewType();

    /**
     * 创建Holder
     *
     * @param convertView
     * @return
     */
    public H createHolder(View convertView);

    /**
     * 绑定数据
     *
     * @param position
     * @param helper
     * @param item
     */
    public void bindData(int position, H helper, T item);

}
