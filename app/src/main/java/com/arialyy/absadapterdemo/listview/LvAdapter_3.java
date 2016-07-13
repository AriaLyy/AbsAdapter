package com.arialyy.absadapterdemo.listview;

import android.content.Context;

import com.arialyy.absadapter.delegate.AbsLvDAdapter;
import com.arialyy.absadapterdemo.delegate.GameDetailDelegate;
import com.arialyy.absadapterdemo.delegate.GameNotifyDelegate;

import java.util.List;

/**
 * Created by lyy on 2016/5/30.
 */
public class LvAdapter_3 extends AbsLvDAdapter {

    public LvAdapter_3(Context context, List data) {
        super(context, data);
        getManager().addDelegate(new GameDetailDelegate(context, this));
        getManager().addDelegate(new GameNotifyDelegate(context, this));
    }

}
