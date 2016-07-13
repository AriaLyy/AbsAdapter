package com.arialyy.absadapterdemo.listview;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.arialyy.absadapter.delegate.AbsDEntity;
import com.arialyy.absadapter.delegate.AbsLvDAdapter;
import com.arialyy.absadapterdemo.delegate.BannerDelegate;
import com.arialyy.absadapterdemo.delegate.GameDetailDelegate;
import com.arialyy.absadapterdemo.delegate.GameNotifyDelegate;

import java.util.List;

/**
 * Created by lyy on 2016/7/5.
 */
public class LvAdapter_1 extends AbsLvDAdapter<AbsDEntity> {
    public LvAdapter_1(Context context, List<AbsDEntity> data, FragmentManager fm) {
        super(context, data);
        getManager().addDelegate(new BannerDelegate(context, this, fm));
        getManager().addDelegate(new GameDetailDelegate(context, this));
        getManager().addDelegate(new GameNotifyDelegate(context, this));
    }
}
