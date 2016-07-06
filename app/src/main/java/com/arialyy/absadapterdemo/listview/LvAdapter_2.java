package com.arialyy.absadapterdemo.listview;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.arialyy.absadapter.delegate.AbsDEntity;
import com.arialyy.absadapter.delegate.AbsLvDAdapter;
import com.arialyy.absadapterdemo.Constance;
import com.arialyy.absadapterdemo.delegate.ImgDelegate;
import com.arialyy.absadapterdemo.delegate.BannerDelegate;
import com.arialyy.absadapterdemo.delegate.RvGameDetailDelegate;
import com.arialyy.absadapterdemo.delegate.RvGameNotifyDelegate;
import com.arialyy.absadapterdemo.delegate.TextDelegate;

import java.util.List;

/**
 * Created by lyy on 2016/7/5.
 */
public class LvAdapter_2 extends AbsLvDAdapter<AbsDEntity> {
    public LvAdapter_2(Context context, List<AbsDEntity> data, FragmentManager fm) {
        super(context, data);
        mManager.addDelegate(new BannerDelegate(context, this, Constance.ADAPTER_TYPE.TYPE_BANNER, fm));
        mManager.addDelegate(new RvGameDetailDelegate(context, this, Constance.ADAPTER_TYPE.TYPE_GAME_DETAIL));
        mManager.addDelegate(new RvGameNotifyDelegate(context, this, Constance.ADAPTER_TYPE.TYPE_NOTIFY));
        mManager.addDelegate(new TextDelegate(context, this, Constance.ADAPTER_TYPE.TYPE_TEXT));
        mManager.addDelegate(new ImgDelegate(context, this, Constance.ADAPTER_TYPE.TYPE_IMG));
    }
}
