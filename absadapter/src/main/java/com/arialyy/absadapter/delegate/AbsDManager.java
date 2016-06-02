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
