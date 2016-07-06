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

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lyy on 2016/3/28.
 */
public class AbsDManager {
    private String TAG = "AbsDManager";
    private SparseArray<AbsIDelegation> mDelegates = new SparseArray<>();
    private Set<Integer> mTypes = new HashSet<>();

    public AbsDManager() {

    }

    public void addDelegate(AbsIDelegation delegation) {
        mDelegates.put(delegation.getItemViewType(), delegation);
        mTypes.add(delegation.getItemViewType());
    }

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
