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
import com.arialyy.absadapterdemo.databinding.ActivityRecycleViewBinding;
import com.arialyy.absadapterdemo.fragment.RvFragment;

import butterknife.Bind;


/**
 * Created by lyy on 2016/5/30.
 */
public class RecycleViewActivity extends BaseActivity<ActivityRecycleViewBinding> {
    @Bind(R.id.vp)
    ViewPager mVp;
    @Bind(R.id.tab)
    TabLayout mTab;

    @Bind(R.id.fb)
    FloatingActionButton mFb;
    SimpleViewPagerAdapter mAdapter;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_recycle_view;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        setupContentViewPager();
        mFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int item = mVp.getCurrentItem();
                ((RvFragment) mAdapter.getItem(item)).delDelegate();
                Toast.makeText(RecycleViewActivity.this, "删除游戏详情样式", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 初始化内容Viewpager
     */
    private void setupContentViewPager() {
        mAdapter = new SimpleViewPagerAdapter(getSupportFragmentManager());
        mAdapter.addFrag(RvFragment.newInstance(0), "rv_adapter_1");
        mAdapter.addFrag(RvFragment.newInstance(1), "rv_adapter_2");
        mAdapter.addFrag(RvFragment.newInstance(2), "rv_adapter_3");
        mVp.setAdapter(mAdapter);
        mVp.setOffscreenPageLimit(3);
        mTab.setupWithViewPager(mVp);
    }
}
