package com.arialyy.absadapterdemo.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import com.arialyy.absadapter.delegate.AbsDEntity;
import com.arialyy.absadapter.delegate.AbsRvDAdapter;
import com.arialyy.absadapter.help.RvItemClickSupport;
import com.arialyy.absadapterdemo.Constance;
import com.arialyy.absadapterdemo.R;
import com.arialyy.absadapterdemo.base.BaseFragment;
import com.arialyy.absadapterdemo.databinding.FragmentRvBinding;
import com.arialyy.absadapterdemo.delegate.GameDetailDelegate;
import com.arialyy.absadapterdemo.module.DataModule;
import com.arialyy.absadapterdemo.recycle_view.RvAdapter_1;
import com.arialyy.absadapterdemo.recycle_view.RvAdapter_2;
import com.arialyy.absadapterdemo.recycle_view.RvAdapter_3;
import com.arialyy.frame.util.show.T;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by lyy on 2016/7/5.
 */
public class RvFragment extends BaseFragment<FragmentRvBinding> {
    @Bind(R.id.list)
    RecyclerView mList;
    List<AbsDEntity> mData = new ArrayList<>();
    AbsRvDAdapter mAdapter;
    int mType = 0;

    public static RvFragment newInstance(int type) {
        Bundle     args     = new Bundle();
        RvFragment fragment = new RvFragment();
        args.putInt(Constance.KEY.RV_ITEM_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }


    public void delDelegate() {
        mAdapter.delDelegate(GameDetailDelegate.class);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_rv;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        mType = getArguments().getInt(Constance.KEY.RV_ITEM_TYPE);
        if (mType == 0) {
            mAdapter = new RvAdapter_1(getContext(), mData, getChildFragmentManager());
        } else if (mType == 1) {
            mAdapter = new RvAdapter_2(getContext(), mData, getChildFragmentManager());
        } else if (mType == 2) {
            mAdapter = new RvAdapter_3(getContext(), mData);
        }
        if (mAdapter == null) return;
        mList.setLayoutManager(new LinearLayoutManager(getContext()));
        mList.setAdapter(mAdapter);
        RvItemClickSupport.addTo(mList).setOnItemClickListener(new RvItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                T.showShort(getContext(), "position: " + position);
            }
        });

        RvItemClickSupport.addTo(mList).setOnItemTouchListener(new RvItemClickSupport.OnItemTouchListener() {
            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e, int position, View v) {

            }
        });
        if (mType == 0) {
            getModule(DataModule.class).getData_1();
        } else if (mType == 1) {
            getModule(DataModule.class).getData_2();
        } else if (mType == 2) {
            getModule(DataModule.class).getData_3();
        }
    }

    private void setUpList(List<AbsDEntity> list) {
        if (list != null && list.size() > 0) {
            mData.addAll(list);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void dataCallback(int result, Object obj) {
        super.dataCallback(result, obj);
        if (result == Constance.CODE.RV_LIST_DATA) {
            setUpList((List<AbsDEntity>) obj);
        }
    }
}
