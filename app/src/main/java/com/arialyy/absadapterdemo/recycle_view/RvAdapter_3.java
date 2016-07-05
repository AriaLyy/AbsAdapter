package com.arialyy.absadapterdemo.recycle_view;

import android.content.Context;

import com.arialyy.absadapter.delegate.recycler_view.AbsRvDAdapter;
import com.arialyy.absadapterdemo.Constance;
import com.arialyy.absadapterdemo.recycle_view.delegate.RvGameDetailDelegate;
import com.arialyy.absadapterdemo.recycle_view.delegate.RvGameNotifyDetegate;
import com.arialyy.absadapterdemo.recycle_view.delegate.RvImgDelegate;
import com.arialyy.absadapterdemo.recycle_view.delegate.RvTextDelegate;

import java.util.List;

/**
 * Created by lyy on 2016/5/30.
 */
public class RvAdapter_3 extends AbsRvDAdapter {

    public RvAdapter_3(Context context, List data) {
        super(context, data);
        mManager.addDelegate(new RvGameDetailDelegate(context, this, Constance.ADAPTER_TYPE.TYPE_GAME_DETAIL));
        mManager.addDelegate(new RvGameNotifyDetegate(context, this, Constance.ADAPTER_TYPE.TYPE_NOTIFY));
    }

}
