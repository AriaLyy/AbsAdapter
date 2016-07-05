package com.arialyy.absadapterdemo.base;

import android.databinding.ViewDataBinding;
import android.os.Bundle;

import com.arialyy.frame.core.AbsFragment;

/**
 * Created by lyy on 2016/7/5.
 */
public abstract class BaseFragment<VB extends ViewDataBinding> extends AbsFragment<VB>{

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected void onDelayLoad() {

    }

    @Override
    protected void dataCallback(int result, Object obj) {

    }
}
