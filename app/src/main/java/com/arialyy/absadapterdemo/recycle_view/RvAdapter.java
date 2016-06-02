package com.arialyy.absadapterdemo.recycle_view;

import android.content.Context;

import com.arialyy.absadapter.delegate.recycler_view.AbsRvDAdapter;
import com.arialyy.absadapterdemo.Constance;

import java.util.List;

/**
 * Created by lyy on 2016/5/30.
 */
public class RvAdapter extends AbsRvDAdapter {


    public RvAdapter(Context context, List data) {
        super(context, data);
        mManager.addDelegate(new RvTextDelegate(context, Constance.ADAPTER_TYPE.TYPE_TEXT));
        mManager.addDelegate(new RvImgDelegate(context, Constance.ADAPTER_TYPE.TYPE_IMG));
    }

}
