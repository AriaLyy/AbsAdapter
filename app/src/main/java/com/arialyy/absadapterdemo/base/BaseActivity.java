package com.arialyy.absadapterdemo.base;

import android.databinding.ViewDataBinding;

import com.arialyy.frame.core.AbsActivity;

/**
 * Created by lyy on 2016/7/5.
 */
public abstract class BaseActivity<VB extends ViewDataBinding> extends AbsActivity<VB>{

    @Override
    protected void dataCallback(int result, Object data) {

    }
}
