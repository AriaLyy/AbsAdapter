package com.arialyy.absadapter.delegate;

import android.view.View;

/**
 * Created by lyy on 2016/5/30.
 */
public interface AbsIDelegation {
    /**
     * 更新
     */
    public void onNotify();

    /**
     * 设置布局
     *
     * @return
     */
    public int setLayoutId();

    /**
     * item的viewType
     * @return
     */
    public int getItemViewType();


}
