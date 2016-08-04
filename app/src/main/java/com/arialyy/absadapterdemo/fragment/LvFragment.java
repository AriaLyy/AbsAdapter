package com.arialyy.absadapterdemo.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.arialyy.absadapter.delegate.AbsDEntity;
import com.arialyy.absadapter.delegate.AbsLvDAdapter;
import com.arialyy.absadapterdemo.Constance;
import com.arialyy.absadapterdemo.R;
import com.arialyy.absadapterdemo.base.BaseFragment;
import com.arialyy.absadapterdemo.databinding.FragmentRvBinding;
import com.arialyy.absadapterdemo.delegate.GameDetailDelegate;
import com.arialyy.absadapterdemo.listview.LvAdapter_1;
import com.arialyy.absadapterdemo.listview.LvAdapter_2;
import com.arialyy.absadapterdemo.listview.LvAdapter_3;
import com.arialyy.absadapterdemo.module.DataModule;
import com.arialyy.frame.util.show.T;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * Created by lyy on 2016/7/5.
 */
public class LvFragment extends BaseFragment<FragmentRvBinding> {
    @InjectView(R.id.list)
    ListView mList;
    List<AbsDEntity> mData = new ArrayList<>();
    AbsLvDAdapter mAdapter;
    int mType = 0;

    public static LvFragment newInstance(int type) {
        Bundle     args     = new Bundle();
        LvFragment fragment = new LvFragment();
        args.putInt(Constance.KEY.RV_ITEM_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_lv;
    }

    public void delDelegate() {
        mAdapter.delDelegate(GameDetailDelegate.class);
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        mType = getArguments().getInt(Constance.KEY.RV_ITEM_TYPE);
        if (mType == 0) {
            mAdapter = new LvAdapter_1(getContext(), mData, getChildFragmentManager());
        } else if (mType == 1) {
            mAdapter = new LvAdapter_2(getContext(), mData, getChildFragmentManager());
        } else if (mType == 2) {
            mAdapter = new LvAdapter_3(getContext(), mData);
        }
        if (mAdapter == null) return;

        mList.setAdapter(mAdapter);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                T.showShort(getContext(), "position: " + position);
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
