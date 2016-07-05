package com.arialyy.absadapterdemo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.arialyy.absadapter.viewpager.SimpleViewPagerAdapter;
import com.arialyy.absadapterdemo.R;
import com.arialyy.absadapterdemo.base.BaseActivity;
import com.arialyy.absadapterdemo.databinding.ActivityRecycleViewBinding;
import com.arialyy.absadapterdemo.fragment.RvFragment;

import butterknife.InjectView;

/**
 * Created by lyy on 2016/5/30.
 */
public class RecycleViewActivity extends BaseActivity<ActivityRecycleViewBinding> {
    @InjectView(R.id.vp)
    ViewPager mVp;
    @InjectView(R.id.tab)
    TabLayout mTab;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_recycle_view;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        setupContentViewPager();
    }

    /**
     * 初始化内容Viewpager
     */
    private void setupContentViewPager() {
        SimpleViewPagerAdapter adapter = new SimpleViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(RvFragment.newInstance(0), "rv_adapter_1");
        adapter.addFrag(RvFragment.newInstance(1), "rv_adapter_2");
        adapter.addFrag(RvFragment.newInstance(2), "rv_adapter_3");
        mVp.setAdapter(adapter);
        mVp.setOffscreenPageLimit(3);
        mTab.setupWithViewPager(mVp);
    }
}
