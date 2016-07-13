package com.arialyy.absadapterdemo.recycle_view;

import android.content.Context;

import com.arialyy.absadapter.delegate.AbsRvDAdapter;
import com.arialyy.absadapterdemo.delegate.GameDetailDelegate;
import com.arialyy.absadapterdemo.delegate.GameNotifyDelegate;

import java.util.List;

/**
 * Created by lyy on 2016/5/30.
 */
public class RvAdapter_3 extends AbsRvDAdapter {

    public RvAdapter_3(Context context, List data) {
        super(context, data);
        getManager().addDelegate(new GameDetailDelegate(context, this));
        getManager().addDelegate(new GameNotifyDelegate(context, this));
    }
}
