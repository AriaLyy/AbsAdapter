package com.arialyy.absadapterdemo.recycle_view;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.arialyy.absadapter.delegate.AbsDEntity;
import com.arialyy.absadapter.delegate.AbsRvDAdapter;
import com.arialyy.absadapterdemo.delegate.BannerDelegate;
import com.arialyy.absadapterdemo.delegate.GameDetailDelegate;
import com.arialyy.absadapterdemo.delegate.GameNotifyDelegate;

import java.util.List;

/**
 * Created by lyy on 2016/7/5.
 */
public class RvAdapter_1 extends AbsRvDAdapter<AbsDEntity> {
    public RvAdapter_1(Context context, List<AbsDEntity> data, FragmentManager fm) {
        super(context, data);
//        getManager().addDelegate(new BannerDelegate(context, this, Constance.ADAPTER_TYPE.TYPE_BANNER, fm));
//        getManager().addDelegate(new GameDetailDelegate(context, this, Constance.ADAPTER_TYPE.TYPE_GAME_DETAIL));
//        getManager().addDelegate(new GameNotifyDelegate(context, this, Constance.ADAPTER_TYPE.TYPE_NOTIFY));

        getManager().addDelegate(new BannerDelegate(context, this,  fm));
        getManager().addDelegate(new GameDetailDelegate(context, this));
        getManager().addDelegate(new GameNotifyDelegate(context, this));
    }
}
