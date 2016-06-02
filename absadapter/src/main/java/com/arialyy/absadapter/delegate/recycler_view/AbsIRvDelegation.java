package com.arialyy.absadapter.delegate.recycler_view;

import android.view.View;

import com.arialyy.absadapter.delegate.AbsIDelegation;
import com.arialyy.absadapter.recycler_view.AbsRVHolder;

/**
 * Created by lyy on 2016/5/30.
 */
interface AbsIRvDelegation<T, H extends AbsRVHolder> extends AbsIDelegation {
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
