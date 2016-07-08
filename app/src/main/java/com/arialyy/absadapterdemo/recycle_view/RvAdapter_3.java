package com.arialyy.absadapterdemo.recycle_view;

import android.content.Context;

import com.arialyy.absadapter.delegate.AbsRvDAdapter;
import com.arialyy.absadapterdemo.Constance;
import com.arialyy.absadapterdemo.delegate.RvGameDetailDelegate;
import com.arialyy.absadapterdemo.delegate.RvGameNotifyDelegate;

import java.util.List;

/**
 * Created by lyy on 2016/5/30.
 */
public class RvAdapter_3 extends AbsRvDAdapter {

    public RvAdapter_3(Context context, List data) {
        super(context, data);
        getManager().addDelegate(new RvGameDetailDelegate(context, this, Constance.ADAPTER_TYPE.TYPE_GAME_DETAIL));
        getManager().addDelegate(new RvGameNotifyDelegate(context, this, Constance.ADAPTER_TYPE.TYPE_NOTIFY));
    }
}
