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

import android.util.Log;
import android.util.SparseArray;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lyy on 2016/3/28.
 */
public class AbsDManager {
    private String                      TAG        = "AbsDManager";
    private SparseArray<AbsIDelegation> mDelegates = new SparseArray<>();
    private Set<Integer>                mTypes     = new HashSet<>();

    public AbsDManager() {

    }

    /**
     * 通过class获取一个样式
     */
    public AbsIDelegation getDelegate(Class clazz) {
        Object[] values;
        try {
            Field field = mDelegates.getClass().getDeclaredField("mValues");
            field.setAccessible(true);
            values = (Object[]) field.get(mDelegates);
            if (values != null && values.length > 0) {
                for (Object delegate : values) {
                    if (delegate == null) {
                        continue;
                    }
                    if (delegate.getClass() == clazz) {
                        return (AbsIDelegation) delegate;
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 删除一个样式
     */
    public void delDelegate(List<AbsDEntity> datas, Class clazz) {
        AbsIDelegation delegation = getDelegate(clazz);
        if (delegation == null) {
            Log.w(TAG, "没有[" + clazz.getName() + "]的样式");
            return;
        }
        int              type  = delegation.getItemViewType();
        List<AbsDEntity> items = new ArrayList<>();
        for (int i = 0, count = datas.size(); i < count; i++) {
            AbsDEntity entity = datas.get(i);
            if (entity.getAbsType() == type) {
                items.add(entity);
            }
        }
        for (AbsDEntity item : items) {
            datas.remove(item);
        }
//        int l = mDelegates.indexOfValue(delegation);
//        mDelegates.remove(l);
        mDelegates.delete(delegation.getItemViewType());
        Log.d(TAG, "haha");
    }

    /**
     * 增加一个样式
     *
     * @param delegation
     */
    public void addDelegate(AbsIDelegation delegation) {
        mDelegates.put(delegation.getItemViewType(), delegation);
        mTypes.add(delegation.getItemViewType());
    }

    /**
     * 通过type获取样式
     *
     * @param itemType
     * @return
     */
    public AbsIDelegation getDelegate(int itemType) {
        try {
            return mDelegates.get(itemType);
        } catch (NullPointerException e) {
            Log.e(TAG, "delegate 为空");
            return null;
        }
    }

    /**
     * ListView 需要在getItemCount 设置itemType的最大值
     *
     * @return
     */
    public int getMaxType() {
        Integer max = 0;
        for (Integer type : mTypes) {
            if (max < type) {
                max = type;
            }
        }
        return max;
    }
}
