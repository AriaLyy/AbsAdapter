package com.arialyy.absadapterdemo.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.arialyy.absadapter.viewpager.SimpleViewPagerAdapter;
import com.arialyy.absadapterdemo.R;
import com.arialyy.absadapterdemo.base.BaseActivity;
import com.arialyy.absadapterdemo.databinding.ActivityListViewBinding;
import com.arialyy.absadapterdemo.fragment.LvFragment;

import butterknife.InjectView;

/**
 * Created by lyy on 2016/5/30.
 */
public class ListViewActivity extends BaseActivity<ActivityListViewBinding> {
    @InjectView(R.id.vp)
    ViewPager            mVp;
    @InjectView(R.id.tab)
    TabLayout            mTab;
    @InjectView(R.id.fb)
    FloatingActionButton mFb;
    SimpleViewPagerAdapter mAdapter;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_list_view;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        setupContentViewPager();
        mFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int item = mVp.getCurrentItem();
                ((LvFragment) mAdapter.getItem(item)).delDelegate();
                Toast.makeText(ListViewActivity.this, "删除游戏详情样式", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 初始化内容Viewpager
     */
    private void setupContentViewPager() {
        mAdapter = new SimpleViewPagerAdapter(getSupportFragmentManager());
        mAdapter.addFrag(LvFragment.newInstance(0), "lv_adapter_1");
        mAdapter.addFrag(LvFragment.newInstance(1), "lv_adapter_2");
        mAdapter.addFrag(LvFragment.newInstance(2), "lv_adapter_3");
        mVp.setAdapter(mAdapter);
        mVp.setOffscreenPageLimit(3);
        mTab.setupWithViewPager(mVp);
    }
}
