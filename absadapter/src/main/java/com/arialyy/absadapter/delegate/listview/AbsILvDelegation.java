package com.arialyy.absadapter.delegate.listview;

import android.view.View;

import com.arialyy.absadapter.delegate.AbsIDelegation;

/**
 * Created by lyy on 2016/3/28.
 */
interface AbsILvDelegation<T, H extends AbsLvDHolder> extends AbsIDelegation {
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
