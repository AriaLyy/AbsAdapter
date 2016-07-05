package com.arialyy.absadapterdemo.recycle_view;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.arialyy.absadapter.delegate.AbsDEntity;
import com.arialyy.absadapter.delegate.recycler_view.AbsRvDAdapter;
import com.arialyy.absadapter.recycler_view.AbsRVAdapter;
import com.arialyy.absadapterdemo.Constance;
import com.arialyy.absadapterdemo.recycle_view.delegate.RvBannerDelegate;
import com.arialyy.absadapterdemo.recycle_view.delegate.RvGameDetailDelegate;
import com.arialyy.absadapterdemo.recycle_view.delegate.RvGameNotifyDetegate;

import java.util.List;

/**
 * Created by lyy on 2016/7/5.
 */
public class RvAdapter_1 extends AbsRvDAdapter<AbsDEntity> {
    public RvAdapter_1(Context context, List<AbsDEntity> data, FragmentManager fm) {
        super(context, data);
        mManager.addDelegate(new RvBannerDelegate(context, this, Constance.ADAPTER_TYPE.TYPE_BANNER, fm));
        mManager.addDelegate(new RvGameDetailDelegate(context, this, Constance.ADAPTER_TYPE.TYPE_GAME_DETAIL));
        mManager.addDelegate(new RvGameNotifyDetegate(context, this, Constance.ADAPTER_TYPE.TYPE_NOTIFY));
    }
}
