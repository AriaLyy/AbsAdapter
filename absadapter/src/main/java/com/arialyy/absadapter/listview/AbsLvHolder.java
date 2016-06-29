package com.arialyy.absadapter.listview;

import android.support.annotation.IdRes;
import android.util.SparseArray;
import android.view.View;

import butterknife.ButterKnife;

//import butterknife.ButterKnife;

/**
 * Created by Lyy on 2015/3/12.
 */
public abstract class AbsLvHolder {
    View mView;
    private SparseArray<View> mViews = new SparseArray<>();

    public AbsLvHolder(View view) {
        ButterKnife.inject(this, view);
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T getView(@IdRes int id) {
        View view = mViews.get(id);
        if (view == null) {
            view = mView.findViewById(id);
            mViews.put(id, view);
        }
        return (T) view;
    }
}
