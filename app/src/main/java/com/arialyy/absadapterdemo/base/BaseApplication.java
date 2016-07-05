package com.arialyy.absadapterdemo.base;

import android.app.Application;

import com.arialyy.frame.core.MVVMFrame;

/**
 * Created by lyy on 2016/6/29.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MVVMFrame.init(this);
    }
}
