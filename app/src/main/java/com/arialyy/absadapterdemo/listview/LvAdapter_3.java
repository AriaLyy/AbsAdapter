package com.arialyy.absadapterdemo.listview;

import android.content.Context;

import com.arialyy.absadapter.delegate.AbsLvDAdapter;
import com.arialyy.absadapterdemo.Constance;
import com.arialyy.absadapterdemo.delegate.RvGameDetailDelegate;
import com.arialyy.absadapterdemo.delegate.RvGameNotifyDelegate;

import java.util.List;

/**
 * Created by lyy on 2016/5/30.
 */
public class LvAdapter_3 extends AbsLvDAdapter {

    public LvAdapter_3(Context context, List data) {
        super(context, data);
        getManager().addDelegate(new RvGameDetailDelegate(context, this));
        getManager().addDelegate(new RvGameNotifyDelegate(context, this));
    }

}
