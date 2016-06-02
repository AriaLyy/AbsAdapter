package com.arialyy.absadapterdemo.listview;

import android.content.Context;

import com.arialyy.absadapter.delegate.listview.AbsLvDAdapter;
import com.arialyy.absadapterdemo.Constance;

import java.util.List;

/**
 * Created by lyy on 2016/5/30.
 */
public class LvAdapter extends AbsLvDAdapter{
    public LvAdapter(Context context, List data) {
        super(context, data);
        mManager.addDelegate(new LvTextDelegate(context, Constance.ADAPTER_TYPE.TYPE_TEXT));
        mManager.addDelegate(new LvImgDelegate(context, Constance.ADAPTER_TYPE.TYPE_IMG));
    }
}
